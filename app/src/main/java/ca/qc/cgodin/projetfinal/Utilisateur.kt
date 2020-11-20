package ca.qc.cgodin.projetfinal

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable
@Entity(tableName = "Users_table")
data class Utilisateur(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    val id:Int,
    @ColumnInfo(name = "email")
    val email: String,
    @ColumnInfo(name = "UserName")
    val UserName: String,
    @ColumnInfo(name = "Password")
    val password: String,
    @ColumnInfo(name = "Restaurants")
    val restaurants: List<Result>

)