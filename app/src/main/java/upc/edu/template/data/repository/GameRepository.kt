package upc.edu.template.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import upc.edu.template.data.remote.GameService
import upc.edu.template.domain.model.Game

class GameRepository(private val gameService: GameService) {
    suspend fun searchGame(genre: String) : List<Game> = withContext(Dispatchers.IO){
        val response = gameService.searchGame(genre)
        if(response.isSuccessful){
            response.body()?.let { it ->
               return@withContext it.map { gameResponse ->
                   gameResponse.toGame()}
            }
        }
        return@withContext emptyList()
    }

    suspend fun getGameById(id: Int): Game? = withContext(Dispatchers.IO) {
        val response = gameService.getGameById(id)
        if (response.isSuccessful) {
            response.body()?.toGame()
        } else {
            null
        }
    }
}