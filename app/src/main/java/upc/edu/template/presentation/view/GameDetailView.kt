package upc.edu.template.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import upc.edu.template.domain.model.Game

@Composable
fun GameDetailView(game: Game) {
    Column(modifier = Modifier.fillMaxSize()) {
        AsyncImage(
            model = game.thumbnail,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(256.dp),
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier.padding(8.dp)) {
            Text(game.title, fontWeight = FontWeight.Bold)
            Text(game.shortDescription)
        }
    }
}