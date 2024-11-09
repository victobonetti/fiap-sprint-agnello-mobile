package com.example.fiap_sprint

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fiap_sprint.ui.theme.FiapsprintTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FiapsprintTheme {
                Surface(
                    modifier = Modifier
                        .background(Color.LightGray)
                        .fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier
                                .background(Color.Green)
                                .width(420.dp)
                                .height(80.dp)
                                .padding(vertical = 16.dp),
                            contentAlignment = Alignment.TopCenter
                        ) {
                            Text(
                                text = "Vinheria Agnello CRUD",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }

                        Surface(
                            shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
                            color = Color.White,
                            modifier = Modifier.fillMaxWidth().offset(y=(-24).dp)
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
                                    modifier = Modifier.align(Alignment.CenterHorizontally).padding(32.dp)
                                )
                                Button(
                                    onClick = { /*TODO*/ },
                                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFBB86FC)),
                                    modifier = Modifier.width(150.dp)
                                ) {
                                    Text("Novo vinho")
                                }

                                Button(
                                    onClick = { /*TODO*/ },
                                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF03DAC5)),
                                    modifier = Modifier.width(150.dp)
                                ) {
                                    Text("Editar vinho")
                                }

                                Button(
                                    onClick = { /*TODO*/ },
                                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF5722)),
                                    modifier = Modifier.width(150.dp)
                                ) {
                                    Text("Remover vinho")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
