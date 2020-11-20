package ca.qc.cgodin.projetfinal.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import ca.qc.cgodin.projetfinal.models.Geometry
import ca.qc.cgodin.projetfinal.models.OpeningHours
import ca.qc.cgodin.projetfinal.models.Photo
import ca.qc.cgodin.projetfinal.models.PlusCode

@Entity(
    tableName = "restaurants"
)
data class Restaurant(
    val business_status: String,
    val geometry: Geometry,
    val icon: String,
    val name: String,
    val opening_hours: OpeningHours,
    val photos: List<Photo>,
    @PrimaryKey(autoGenerate = false)
    val place_id: String,
    val plus_code: PlusCode,
    val price_level: Int,
    val rating: Double,
    val reference: String,
    val scope: String,
    val types: List<String>,
    val user_ratings_total: Int,
    val vicinity: String
)