package com.example.fiap_sprint.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fiap_sprint.WineViewModel
import com.example.fiap_sprint.components.AppHeader
import com.example.fiap_sprint.components.VinhoRow

@Composable
fun TelaPrincipal(navController: NavController, wineViewModel: WineViewModel){

    val wines by wineViewModel.wines.observeAsState(emptyList())


    Surface(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AppHeader()

            Surface(
                shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-24).dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = "Escolha uma opção",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(32.dp)
                    )

                    Button(
                        onClick = { navController.navigate("novo") },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFBB86FC)),
                        modifier = Modifier.width(150.dp)
                    ) {
                        Text("+ Novo vinho")
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Divider(color = Color.LightGray)
                        wines.forEach { wine -> VinhoRow(navController, wine, wineViewModel) }
                    }
                }
            }
        }
    }
}