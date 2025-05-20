package upc.edu.template.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import upc.edu.template.data.local.GameDao
import upc.edu.template.data.model.GameEntity
import upc.edu.template.domain.model.FavoriteGame

class FavoriteGameRepository (private val gameDao: GameDao){
    suspend fun addFavoriteGame(game: FavoriteGame) = withContext(Dispatchers.IO) {
        gameDao.insertGame(GameEntity.fromFavoriteGame(game))
    }

    suspend fun removeFavoriteGameById(id: Int) = withContext(Dispatchers.IO) {
        gameDao.deleteGameById(id)
    }

    suspend fun isFavorite(id: Int): Boolean = withContext(Dispatchers.IO) {
        gameDao.fetchGameById(id) != null
    }

    suspend fun getAllFavorites(): List<FavoriteGame> = withContext(Dispatchers.IO) {
        gameDao.fetchGames().map { it.toFavoriteGame() }
    }
}