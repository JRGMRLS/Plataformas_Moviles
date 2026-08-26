package com.example.lab5

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Directions
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab5.ui.theme.Lab5Theme
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Lab5Theme {
                RestaurantScreen()
            }
        }
    }
}

@Composable
fun RestaurantScreen() {
    val context = LocalContext.current

    val darkMode = isSystemInDarkTheme()

    val greenButton = if (darkMode) {
        Color(0xFFB7CCB8)
    } else {
        Color(0xFFC8DEC9)
    }

    val greenButtonText = if (darkMode) {
        Color(0xFF243B27)
    } else {
        Color(0xFF29472E)
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            // Barra de actualización
            Surface(
                color = MaterialTheme.colorScheme.errorContainer,
                contentColor = MaterialTheme.colorScheme.onErrorContainer,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 16.dp,
                            vertical = 10.dp
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    FilledTonalIconButton(
                        onClick = {
                            Toast.makeText(
                                context,
                                "Actualización disponible",
                                Toast.LENGTH_SHORT
                            ).show()
                        },
                        colors = IconButtonDefaults.filledTonalIconButtonColors(
                            containerColor = MaterialTheme.colorScheme.error,
                            contentColor = MaterialTheme.colorScheme.onError
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Default.Refresh,
                            contentDescription = "Actualizar"
                        )
                    }

                    Text(
                        text = "Actualización disponible",
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 12.dp),
                        color = MaterialTheme.colorScheme.onErrorContainer
                    )

                    TextButton(
                        onClick = {
                            val playStoreIntent = Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse(
                                    "market://details?id=com.whatsapp"
                                )
                            )

                            try {
                                context.startActivity(playStoreIntent)
                            } catch (exception: ActivityNotFoundException) {
                                val webIntent = Intent(
                                    Intent.ACTION_VIEW,
                                    Uri.parse(
                                        "https://play.google.com/store/apps/" +
                                                "details?id=com.whatsapp"
                                    )
                                )

                                context.startActivity(webIntent)
                            }
                        },
                        colors = ButtonDefaults.textButtonColors(
                            contentColor =
                                MaterialTheme.colorScheme.error
                        )
                    ) {
                        Text(
                            text = "Descargar",
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                // Día y fecha
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.large,
                    color = MaterialTheme.colorScheme.primaryContainer,
                    contentColor =
                        MaterialTheme.colorScheme.onPrimaryContainer,
                    tonalElevation = 2.dp
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "Martes",
                                fontSize = 36.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = "2 de junio de 2026",
                                fontSize = 18.sp
                            )
                        }

                        ElevatedButton(
                            onClick = {
                                Toast.makeText(
                                    context,
                                    "Jornada terminada",
                                    Toast.LENGTH_SHORT
                                ).show()
                            },
                            colors =
                                ButtonDefaults.elevatedButtonColors(
                                    containerColor =
                                        MaterialTheme.colorScheme.surface,
                                    contentColor =
                                        MaterialTheme.colorScheme.primary
                                )
                        ) {
                            Text("Terminar jornada")
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Tarjeta del restaurante
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor =
                            MaterialTheme.colorScheme.secondaryContainer,
                        contentColor =
                            MaterialTheme.colorScheme.onSecondaryContainer
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(18.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.Top
                        ) {
                            Column(
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(
                                    text = "TGI Fridays Majadas",
                                    fontSize = 26.sp,
                                    fontWeight = FontWeight.Bold
                                )

                                Spacer(modifier = Modifier.height(6.dp))

                                Text(
                                    text =
                                        "Parque Comercial Las Majadas, zona 11",
                                    color = MaterialTheme.colorScheme
                                        .onSecondaryContainer,
                                    maxLines = 1
                                )

                                Spacer(modifier = Modifier.height(6.dp))

                                Text(
                                    text = "12:00 p. m. – 10:00 p. m.",
                                    color = MaterialTheme.colorScheme
                                        .onSecondaryContainer
                                )
                            }

                            // Botón para abrir Google Maps
                            FilledTonalIconButton(
                                onClick = {
                                    val location =
                                        "geo:0,0?" +
                                                "q=14.6210246,-90.5609009" +
                                                "(TGI Fridays Majadas)"

                                    val mapsIntent = Intent(
                                        Intent.ACTION_VIEW,
                                        Uri.parse(location)
                                    )

                                    context.startActivity(mapsIntent)
                                },
                                colors = IconButtonDefaults
                                    .filledTonalIconButtonColors(
                                        containerColor =
                                            MaterialTheme.colorScheme
                                                .tertiary,
                                        contentColor =
                                            MaterialTheme.colorScheme
                                                .onTertiary
                                    )
                            ) {
                                Icon(
                                    imageVector =
                                        Icons.Default.Directions,
                                    contentDescription =
                                        "Abrir ubicación en Maps"
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement =
                                Arrangement.spacedBy(12.dp)
                        ) {

                            // Botón Iniciar
                            Button(
                                onClick = {
                                    Toast.makeText(
                                        context,
                                        "Jorge Andres Morales Solorzano",
                                        Toast.LENGTH_LONG
                                    ).show()
                                },
                                modifier = Modifier.weight(1f),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = greenButton,
                                    contentColor = greenButtonText
                                )
                            ) {
                                Text("Iniciar")
                            }

                            // Botón Detalles
                            ElevatedButton(
                                onClick = {
                                    Toast.makeText(
                                        context,
                                        "Comida americana\nPrecio: QQ",
                                        Toast.LENGTH_LONG
                                    ).show()
                                },
                                modifier = Modifier.weight(1f),
                                colors = ButtonDefaults.elevatedButtonColors(
                                    containerColor = greenButton,
                                    contentColor = greenButtonText
                                )
                            ) {
                                Text("Detalles")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RestaurantScreenPreview() {
    Lab5Theme {
        RestaurantScreen()
    }
}