package com.example.fiap_sprint

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fiap_sprint.db.WineRepository
import com.example.fiap_sprint.screens.TelaEditarVinho
import com.example.fiap_sprint.screens.TelaNovoVinho
import com.example.fiap_sprint.screens.TelaPrincipal
import com.example.fiap_sprint.screens.TelaRemoveVinho
import com.example.fiap_sprint.ui.theme.FiapsprintTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            FiapsprintTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "inicio"
                ) {
                    composable(route = "inicio") { TelaPrincipal(navController, WineViewModel(WineRepository(
                        LocalContext.current)) )}
                    composable(route = "novo") { TelaNovoVinho(navController, WineViewModel(WineRepository(LocalContext.current)) )}
                    composable(route = "remover/{id}") { backStackEntry ->
                        val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
                            if (id != null) {
                                TelaRemoveVinho(navController, id, WineViewModel(WineRepository(LocalContext.current)))
                            }
                        }
                    composable(route = "editar/{id}") { backStackEntry ->
                        val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
                        if (id != null) {
                            TelaEditarVinho(navController, id, WineViewModel(WineRepository(LocalContext.current)))
                        }
                    }
                }
            }
        }
    }
}
