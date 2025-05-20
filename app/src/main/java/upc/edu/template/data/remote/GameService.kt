package upc.edu.template.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import upc.edu.template.data.model.GameResponse

interface GameService {
    @GET("games")
    suspend fun searchGame(@Query("genre") genre: String): Response<List<GameResponse>>
    @GET("game")
    suspend fun getGameById(@Query("id") id:Int): Response<GameResponse>
}