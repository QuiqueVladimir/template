package upc.edu.template.data.local

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

interface GameDao {
    @Insert
    suspend fun insertNews(entity: GameEntity)

    @Delete
    suspend fun deleteNews(entity: GameEntity)

    @Query("SELECT * FROM news")
    suspend fun getAllNews(): List<GameEntity>

    @Query("SELECT * FROM news WHERE title = :title LIMIT 1")
    suspend fun getNewsByTitle(title: String): NewsEntity?
}