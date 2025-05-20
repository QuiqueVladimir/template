package upc.edu.template.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import upc.edu.template.data.model.GameEntity

@Database(entities = [GameEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun gameDao(): GameDao
}