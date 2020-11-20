package ca.qc.cgodin.projetfinal.bd

import androidx.room.TypeConverter
import ca.qc.cgodin.projetfinal.models.*

class Converters {

    // GEOMETRY
    @TypeConverter
    fun fromGeometry(geometry: Geometry): String {
        return geometry.location.lat.toString() +","+ geometry.location.lng
    }
    @TypeConverter
    fun toGeometry(location: Location, viewport: Viewport): Geometry{
        return Geometry(location, viewport)
    }

    // LOCATION
    @TypeConverter
    fun fromLocation(location: Location): String {
        return location.lat.toString() + "," + location.lng.toString()
    }
    @TypeConverter
    fun toLocation(lat: Double, lng: Double): Location{
        return Location(lat, lng)
    }

    // VIEWPORT
    @TypeConverter
    fun fromViewport(viewport: Viewport): String {
        return viewport.northeast.lat.toString() +","+ viewport.northeast.lng.toString() +
                viewport.southwest.lat.toString() +";"+ viewport.southwest.lng.toString()
    }
    @TypeConverter
    fun toViewport(lat1: Double, lng1:Double, lat2:Double, lng2: Double): Viewport {
        return Viewport(Northeast(lat1,lng1), Southwest(lat2,lng2))
    }

        // NORTHEAST
        @TypeConverter
        fun fromNortheast(northeast: Northeast): String {
            return northeast.lat.toString() + "," + northeast.lng.toString()
        }
        @TypeConverter
        fun toNortheast(lat: Double, lng: Double): Northeast{
            return Northeast(lat, lng)
        }

        // SOUTHWEST
        @TypeConverter
        fun fromSouthwest(southwest: Southwest): String {
            return southwest.lat.toString() + "," + southwest.lng.toString()
        }
        @TypeConverter
        fun toSouthwest(lat: Double, lng: Double): Southwest{
            return Southwest(lat, lng)
        }

    // OPENING_HOURS
    @TypeConverter
    fun fromOpeningHours(openingHours: OpeningHours): Boolean {
        return openingHours.open_now
    }
    @TypeConverter
    fun toOpeningHours(open_now: Boolean): OpeningHours {
        return OpeningHours(open_now)
    }

    // PHOTOS
    @TypeConverter
    fun fromPhotos(photo: Photo): String {
        return photo.photo_reference
    }
    @TypeConverter
    fun toPhotos(height: Int, html_attributions: List<String>, photo_reference: String, width: Int): Photo{
        return Photo(height, html_attributions, photo_reference, width)
    }

    // PLUS_CODE
    @TypeConverter
    fun fromPlusCode(plusCode: PlusCode): String {
        return plusCode.compound_code + ";" + plusCode.global_code
    }
    @TypeConverter
    fun toPlusCode(compoundCode: String, globalCode: String): PlusCode {
        return PlusCode(compoundCode, globalCode)
    }

}