package ca.qc.cgodin.projetfinal.bd

import androidx.lifecycle.LiveData
import androidx.room.*
import ca.qc.cgodin.projetfinal.Restaurant

@Dao
interface RestaurantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(restaurant: Restaurant): Long

    @Query("SELECT * FROM restaurants")
    fun getAllRestaurants(): LiveData<List<Restaurant>>

    @Delete
    suspend fun deleteRestaurant(restaurant: Restaurant)

}