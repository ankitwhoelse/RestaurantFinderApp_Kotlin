package ca.qc.cgodin.projetfinal.bd

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ca.qc.cgodin.projetfinal.models.Restaurant

@Database(
    entities = [Restaurant::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class RestaurantDatabase: RoomDatabase() {

    abstract fun getRestaurantDao(): RestaurantDao

    companion object {
        @Volatile
        private var instance: RestaurantDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance?: synchronized(LOCK) {
            instance?: createDatabase(context).also {instance = it}
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                RestaurantDatabase::class.java,
                "retaurant_db.db"
            ).build()
    }
}