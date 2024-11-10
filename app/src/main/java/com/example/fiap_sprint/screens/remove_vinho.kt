package com.example.fiap_sprint.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fiap_sprint.WineViewModel

@Composable
fun TelaRemoveVinho(navController: NavController, id: Int, wineViewModel: WineViewModel) {

    val foundWine = wineViewModel.find(id)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Deseja remover o vinho?",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Button(
            onClick = {
                try {
                    wineViewModel.onRemoveWine(id)

                } finally {
                    navController.navigate("inicio")

                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF06292))

        ) {
            Text("Confirmar")
        }

        Button(
            onClick = {
                navController.navigate("inicio")
            }
        ) {
            Text("Voltar")
        }
    }
}
