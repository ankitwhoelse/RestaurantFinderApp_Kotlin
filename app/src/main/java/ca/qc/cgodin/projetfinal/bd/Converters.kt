package ca.qc.cgodin.projetfinal.bd

import android.view.View
import androidx.room.TypeConverter
import ca.qc.cgodin.projetfinal.models.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class Converters {

    // GEOMETRY
    @TypeConverter
    fun fromGeometry(geometry: Geometry): String {
        return Gson().toJson(geometry)
    }
    @TypeConverter
    fun toGeometry(stringGeometry: String): Geometry{
        return Gson().fromJson(stringGeometry, Geometry::class.java)
    }

        // LOCATION
        @TypeConverter
        fun fromLocation(location: Location): String {
            return Gson().toJson(location)
        }
        @TypeConverter
        fun toLocation(stringLocation: String): Location{
            return Gson().fromJson(stringLocation, Location::class.java)
        }

        // VIEWPORT
        @TypeConverter
        fun fromViewport(viewport: Viewport): String {
            return Gson().toJson(viewport)
        }
        @TypeConverter
        fun toViewport(stringViewport: String): Viewport {
            return Gson().fromJson(stringViewport, Viewport::class.java)
        }

        // NORTHEAST
        @TypeConverter
        fun fromNortheast(northeast: Northeast): String {
            return Gson().toJson(northeast)
        }
        @TypeConverter
        fun toNortheast(stringNortheast: String): Northeast{
            return Gson().fromJson(stringNortheast, Northeast::class.java)
        }

        // SOUTHWEST
        @TypeConverter
        fun fromSouthwest(southwest: Southwest): String {
            return Gson().toJson(southwest)
        }
        @TypeConverter
        fun toSouthwest(stringSouthwest: String): Southwest{
            return Gson().fromJson(stringSouthwest, Southwest::class.java)
        }

    // OPENING_HOURS
    @TypeConverter
    fun fromOpeningHours(openingHours: OpeningHours): String {
        return Gson().toJson(openingHours)
    }
    @TypeConverter
    fun toOpeningHours(stringOpeningHours: String): OpeningHours {
        return Gson().fromJson(stringOpeningHours, OpeningHours::class.java)
    }

    // PHOTO
    @TypeConverter
    fun fromPhotos(photos: List<Photo>): String {
        return Gson().toJson(photos)
    }
    @TypeConverter
    fun toPhotos(photosString: String): List<Photo>{
        return Gson().fromJson(photosString, listOf<Photo>()::class.java)
    }

    // PLUS_CODE
    @TypeConverter
    fun fromPlusCode(plusCode: PlusCode): String {
        return Gson().toJson(plusCode)
    }
    @TypeConverter
    fun toPlusCode(globalCode: String): PlusCode {
        return Gson().fromJson(globalCode, PlusCode::class.java)
    }

    @TypeConverter // note this annotation
    fun fromListeRestaurant(restaurants: List<Restaurant?>?): String? {
        if (restaurants == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<List<Restaurant?>?>() {}.type
        return gson.toJson(restaurants, type)
    }

    @TypeConverter // note this annotation
    fun toListeRestaurant(restaurantString: String?): List<Restaurant>? {
        if (restaurantString == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<List<Restaurant?>?>() {}.type
        return gson.fromJson<List<Restaurant>>(restaurantString, type)
    }
}