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
    val firstName: String,
    @ColumnInfo(name = "UserName")
    val lastName: String,
    @ColumnInfo(name = "Password")
    val phoneNumber: String

)