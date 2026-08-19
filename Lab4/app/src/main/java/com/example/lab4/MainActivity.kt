package com.example.lab4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.material3.Text
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Portada()
        }
    }
}

@Composable
fun Portada(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .border(
                width = 4.dp,
                color = Color(0xFF006633)
            )
    ) {

        Image(
            painter = painterResource(id = R.drawable.escudo_uvg),
            contentDescription = null,
            modifier = Modifier
                .size(300.dp)
                .align(Alignment.Center),
            contentScale = ContentScale.Fit,
            alpha = 0.12f
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Universidad del Valle\nde Guatemala",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            Text(
                text = "Programación de plataformas\nmóviles, Sección 21",
                fontSize = 22.sp,
                textAlign = TextAlign.Center
            )

            Spacer(
                modifier = Modifier.height(28.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {

                Text(
                    text = "INTEGRANTES",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Jorge Morales", fontSize = 15.sp)
                    Text("David Berganza", fontSize = 15.sp)
                    Text("Wilfred Orellana", fontSize = 15.sp)
                }
            }

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {

                Text(
                    text = "CATEDRÁTICO",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )

                Text(
                    text = "Juan Carlos Durini",
                    fontSize = 15.sp,
                    modifier = Modifier.weight(1f),

                )
            }

            Spacer(
                modifier = Modifier.height(28.dp)
            )

            Text(
                text = "Jorge Morales",
                fontSize = 15.sp
            )

            Text(
                text = "24284",
                fontSize = 15.sp
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun Preview() {
    Portada()
}