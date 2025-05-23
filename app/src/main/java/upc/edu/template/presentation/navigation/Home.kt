package upc.edu.template.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import upc.edu.template.presentation.di.PresentationModule
import upc.edu.template.presentation.view.GameDetailView
import upc.edu.template.presentation.view.SearchGameView

@Preview
@Composable
fun Home(){
    val navController = rememberNavController()

    val navigationItems = listOf(
        NavigationItem(
            icon = Icons.Default.Search,
            title = "search",
            route = "search_games"
        ),
        NavigationItem(
            icon = Icons.Default.Favorite,
            title = "favorites",
            route = "favorites"
        ),
    )

    val selectedIndex = remember {
        mutableIntStateOf(0)
    }

    val searchGameViewModel = PresentationModule.getSearchGameViewModel()

    Scaffold(
        bottomBar = {
            NavigationBar {
                navigationItems.forEachIndexed{index, item ->
                    NavigationBarItem(
                        selected = selectedIndex.intValue == index,
                        icon = {
                            Icon(item.icon, contentDescription = null)
                        },
                        onClick = {
                            selectedIndex.intValue = index
                            navController.navigate(item.route)
                        },
                        label = {
                            Text(item.title)
                        }
                    )
                }
            }
        }
    ) { padding ->
        NavHost(
            navController,
            startDestination = "search_games",
            modifier = Modifier.padding(padding)
        ){
            composable("search_games"){
                SearchGameView(searchGameViewModel){ gameId ->
                    navController.navigate("game_detail/${gameId}")
                }
            }
            composable("game_detail/{gameId}") { backStackEntry ->
                val gameId = backStackEntry.arguments?.getString("gameId")?.toIntOrNull()
                    ?: return@composable
                searchGameViewModel.getGameById(gameId)
                val gameDetail = searchGameViewModel.gameDetail.observeAsState()
                gameDetail.value?.let { game ->
                    GameDetailView(game)
                }
            }
            composable("favorites"){
                // Aquí va el contenido de la pantalla 3
            }
        }
    }

}

data class NavigationItem(
    val icon: ImageVector,
    val title: String,
    val route: String
)