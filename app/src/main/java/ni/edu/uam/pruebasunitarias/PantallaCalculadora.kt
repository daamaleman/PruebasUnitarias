package ni.edu.uam.pruebasunitarias

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp

@Composable
fun PantallaCalculadora() {
    val calculadora = remember { Calculadora() }
    var resultado by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            // Botón 1: Suma
            Button(
                onClick = { resultado = calculadora.sumar(5, 3).toString() }
            ) {
                Text("Sumar (5+3)")
            }

            // Botón 2: Resta (Actividad Complementaria)
            Button(
                onClick = { resultado = calculadora.restar(10, 4).toString() }
            ) {
                Text("Restar (10-4)")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = resultado,
            modifier = Modifier.testTag("resultado")
        )
    }
}
