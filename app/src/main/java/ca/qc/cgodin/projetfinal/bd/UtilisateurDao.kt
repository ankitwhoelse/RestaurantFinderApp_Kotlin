package ca.qc.cgodin.projetfinal.bd

import androidx.lifecycle.LiveData
import androidx.room.*
import ca.qc.cgodin.projetfinal.Utilisateur
import ca.qc.cgodin.projetfinal.models.Restaurant

@Dao
interface UtilisateurDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun upsert(utilisateur: Utilisateur): Long

    @Query("SELECT * FROM Utilisateurs")
    fun getAllUtilisateurs(): LiveData<List<Utilisateur>>
   /* @Query("SELECT Restaurants FROM Utilisateurs")
    fun getAllRestaurants(): LiveData<List<Restaurant>>*/

    @Query("UPDATE Utilisateurs SET Restaurants = :listeResto WHERE id = :uid")
    fun updateRestaurants(listeResto: List<Restaurant>, uid: String?): Int
    @Delete
    suspend fun deleteRestaurant(utilisateur: Utilisateur)

}