package upc.edu.template.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Preview
@Composable
fun Home(){
    val navController = rememberNavController()

    val navigationItems = listOf(
        NavigationItem(
            icon = Icons.Default.Home,
            title = "Elegir icono",
            route = "destinoInicial"
        ),
        NavigationItem(
            icon = Icons.Default.Face,
            title = "Elegir icono",
            route = "destino2"
        ),
    )

    val selectedIndex = remember {
        mutableIntStateOf(0)
    }

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
            startDestination = "destinoInicial",
            modifier = Modifier.padding(padding)
        ){
            composable("destinoInicial"){
                // Aquí va el contenido de la pantalla inicial
            }
            composable("destino2"){
                // Aquí va el contenido de la pantalla 2
            }
            composable("destino3"){
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