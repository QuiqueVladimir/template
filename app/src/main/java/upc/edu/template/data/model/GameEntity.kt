package upc.edu.template.data.model

import androidx.room.PrimaryKey
import upc.edu.template.domain.model.FavoriteGame
import upc.edu.template.domain.model.Game

data class GameEntity(
    @PrimaryKey
    val title: String,
    val thumbnail: String,
    val shortDescription: String,
    val gameUrl: String,
    val genre: String
){
    fun toFavoriteGame(): FavoriteGame{
        return FavoriteGame(
            id = 0,
            title = title,
            thumbnail = thumbnail,
            shortDescription = shortDescription,
            gameUrl = gameUrl,
            genre = genre
        )
    }
    companion object{
        fun fromGame(game: Game): GameEntity{
            return GameEntity(
                title = game.title,
                thumbnail = game.thumbnail,
                shortDescription = game.shortDescription,
                gameUrl = game.gameUrl,
                genre = game.genre
            )
        }
        fun fromFavoriteGame(game: FavoriteGame): GameEntity{
            return GameEntity(
                title = game.title,
                thumbnail = game.thumbnail,
                shortDescription = game.shortDescription,
                gameUrl = game.gameUrl,
                genre = game.genre
            )
        }
    }
}

