package com.example.fiap_sprint.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fiap_sprint.Wine
import com.example.fiap_sprint.WineViewModel

@Composable
fun VinhoRow(navController: NavController, wine: Wine, wineViewModel: WineViewModel){

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = wine.name,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )
            Text(
                text = "R$ ${wine.price}",
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
        Row {
            Button(
                onClick = { navController.navigate("editar/" + wine.id) },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF64B5F6)),
                modifier = Modifier.padding(end = 8.dp)
            ) {
                Text("Editar")
            }
            Button(
                onClick = {
                    wineViewModel.onRemoveWine(wine.id)
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF06292))
            ) {
                Text("Excluir")
            }
        }
    }
    Divider(color = Color.LightGray)
}