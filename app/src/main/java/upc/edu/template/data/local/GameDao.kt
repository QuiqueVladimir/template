package upc.edu.template.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import upc.edu.template.data.model.GameEntity

@Dao
interface GameDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGame(entity: GameEntity)

    @Delete
    suspend fun deleteGame(entity: GameEntity)

    @Query("DELETE FROM games WHERE id = :id")
    suspend fun deleteGameById(id: Int)

    @Query("SELECT * FROM games")
    suspend fun fetchGames(): List<GameEntity>

    @Query("SELECT * FROM games WHERE id = :id LIMIT 1")
    suspend fun fetchGameById(id: Int): GameEntity?
}