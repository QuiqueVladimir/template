package upc.edu.template.data.model

import com.google.gson.annotations.SerializedName
import upc.edu.template.domain.model.Game

data class GameResponse(
    val id: Int,
    val title: String?,
    val thumbnail: String?,
    @SerializedName("short_description")
    val shortDescription: String?,
    @SerializedName("game_url")
    val gameUrl: String?,
    val genre: String?,
    val platform: String?,
    val publisher: String?,
    val developer: String?,
    @SerializedName("release_date")
    val releaseDate: String?,
    val freetogameProfileUrl: String?
){
    fun toGame(): Game{
        return Game(
            id= id,
            title= title ?: "",
            thumbnail= thumbnail ?: "",
            shortDescription= shortDescription ?: "",
            gameUrl= gameUrl ?: "",
            genre= genre ?: "",
            releaseDate= releaseDate ?: ""
        )
    }
}
