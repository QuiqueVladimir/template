package upc.edu.template.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import upc.edu.template.data.repository.GameRepository
import upc.edu.template.domain.model.Game

class SearchGameViewModel(private val gameRepository: GameRepository): ViewModel() {
    private val _game = MutableStateFlow<List<Game>>(emptyList())
    private val _gameDetail = MutableLiveData<Game?>()

    val game: StateFlow<List<Game>> = _game
    val gameDetail: LiveData<Game?> get() = _gameDetail

    fun searchGame(genre: String){
        viewModelScope.launch{
            _game.value = gameRepository.searchGame(genre)
        }
    }
    fun getGameById(id: Int){
        viewModelScope.launch{
            _gameDetail.value = gameRepository.getGameById(id)
        }
    }
}