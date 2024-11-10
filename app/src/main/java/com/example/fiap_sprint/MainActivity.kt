package com.example.fiap_sprint

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fiap_sprint.screens.TelaEditarVinho
import com.example.fiap_sprint.screens.TelaNovoVinho
import com.example.fiap_sprint.screens.TelaPrincipal
import com.example.fiap_sprint.ui.theme.FiapsprintTheme
import com.example.fiap_sprint.WineViewModel as WineViewModel

data class Wine(var id: Int, val name: String, val price: Double)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FiapsprintTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "inicio"
                ){
                    val wineVm = WineViewModel()
                    composable(route = "inicio") { TelaPrincipal(navController, wineVm) }
                    composable(route = "novo") { TelaNovoVinho(navController, wineVm)}
                    composable(route = "editar/{id}") {
                        val id: String? = it.arguments?.getString("id", "")
                        if (id != null) {
                            TelaEditarVinho(navController, id.toInt(), wineVm)
                        }
                    }
                }


            }
        }
    }
}
