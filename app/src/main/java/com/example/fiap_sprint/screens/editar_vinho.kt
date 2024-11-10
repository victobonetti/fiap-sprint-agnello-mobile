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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fiap_sprint.Wine
import com.example.fiap_sprint.WineViewModel

@Composable
fun TelaEditarVinho(navController: NavController, id: Int, wineViewModel: WineViewModel) {

    val foundWine = wineViewModel.find(id)
    val nomeVinho = remember { mutableStateOf(foundWine.name) }
    val precoVinho = remember { mutableDoubleStateOf(foundWine.price) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Editar Vinho",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 24.dp)
        )


        OutlinedTextField(
            value = nomeVinho.value,
            onValueChange = { nomeVinho.value = it },
            label = {
                Text("Nome")
                    },
            modifier = Modifier.fillMaxWidth()

        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = precoVinho.doubleValue.toString(),
            onValueChange = {
                precoVinho.doubleValue = it.toDouble()
            },
            label = { Text("Preço") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                try {
                    wineViewModel.onEditWine(id, nomeVinho.value, precoVinho.value)
                } finally {
                    navController.navigate("inicio")
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Confirmar")
        }

        Button(
            onClick = {
                navController.navigate("inicio")
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF06292))
        ) {
            Text("Voltar")
        }
    }
}
