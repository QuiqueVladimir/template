package upc.edu.template.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import upc.edu.template.domain.model.Game
import upc.edu.template.presentation.viewmodel.SearchGameViewModel

@Composable
fun SearchGameView(viewModel: SearchGameViewModel, OnGameClick : (Int) -> Unit) {

    val genre = remember {
        mutableStateOf("")
    }

    val games = viewModel.game.collectAsState()

    Column(modifier = Modifier.fillMaxSize()){
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            value = genre.value,
            onValueChange = {
                genre.value = it
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        viewModel.searchGame(genre.value)
                    }
                ) {
                    Icon(Icons.Default.Search, contentDescription = null)
                }
            }
        )
        LazyColumn {
            items(games.value) { games ->
                GameListItemView(games, OnGameClick)
            }
        }
    }
}

@Composable
fun GameListItemView(
    game: Game,
    //ver detalle
    onGameClick: (Int) -> Unit
){
    Card(
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
        onClick = {
            //ver detalle
            onGameClick(game.id)
        }
        ) {
        Column {
            AsyncImage(
                model = game.thumbnail,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(256.dp),
                contentScale = ContentScale.Crop
            )
        }
        Column(modifier = Modifier.padding(8.dp)) {
            Text(game.title, fontWeight = Bold, maxLines = 1)
            Text(game.genre)
            Text(game.releaseDate)
        }
    }
}