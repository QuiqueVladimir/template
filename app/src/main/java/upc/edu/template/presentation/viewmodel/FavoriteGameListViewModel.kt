package upc.edu.template.presentation.viewmodel

import androidx.lifecycle.ViewModel
import upc.edu.template.data.repository.FavoriteGameRepository
import upc.edu.template.domain.model.FavoriteGame

class FavoriteGameListViewModel(private val favoriteGameRepository: FavoriteGameRepository) :
ViewModel() {
    suspend fun addFavorite(game: FavoriteGame) {
        favoriteGameRepository.addFavoriteGame(game)
    }

    suspend fun removeFavoriteById(id: Int) {
        favoriteGameRepository.removeFavoriteGameById(id)
    }

    suspend fun isFavorite(id: Int): Boolean {
        return favoriteGameRepository.isFavorite(id)
    }

    suspend fun getFavorites(): List<FavoriteGame> {
        return favoriteGameRepository.getAllFavorites()
    }
}