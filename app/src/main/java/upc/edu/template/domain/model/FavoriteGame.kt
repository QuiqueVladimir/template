package upc.edu.template.domain.model

data class FavoriteGame (
    val id: Int,
    val title: String,
    val thumbnail: String,
    val shortDescription: String,
    val gameUrl: String,
    val genre: String,
)