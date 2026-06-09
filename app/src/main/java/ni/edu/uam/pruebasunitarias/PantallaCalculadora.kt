package ni.edu.uam.pruebasunitarias

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PantallaCalculadora() {
    val calculadora = remember { Calculadora() }
    var expresion by remember { mutableStateOf("0") }
    var primerOperando by remember { mutableStateOf<Double?>(null) }
    var operacionPendiente by remember { mutableStateOf<String?>(null) }
    var nuevoNumero by remember { mutableStateOf(true) }

    fun calcular() {
        val segundoOperando = expresion.toDoubleOrNull()
        if (primerOperando != null && segundoOperando != null && operacionPendiente != null) {
            val resultado = when (operacionPendiente) {
                "+" -> calculadora.sumar(primerOperando!!, segundoOperando)
                "-" -> calculadora.restar(primerOperando!!, segundoOperando)
                "*" -> calculadora.multiplicar(primerOperando!!, segundoOperando)
                "/" -> try { calculadora.dividir(primerOperando!!, segundoOperando) } catch (e: Exception) { null }
                else -> segundoOperando
            }
            expresion = if (resultado == null) "Error" else {
                if (resultado % 1 == 0.0) resultado.toInt().toString() else resultado.toString()
            }
            primerOperando = null
            operacionPendiente = null
            nuevoNumero = true
        }
    }

    fun onNumeroClick(numero: String) {
        if (nuevoNumero || expresion == "0" || expresion == "Error") {
            expresion = numero
            nuevoNumero = false
        } else {
            expresion += numero
        }
    }

    fun onOperacionClick(op: String) {
        if (operacionPendiente != null && !nuevoNumero) {
            calcular()
        }
        primerOperando = expresion.toDoubleOrNull()
        operacionPendiente = op
        nuevoNumero = true
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(
            text = expresion,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp)
                .testTag("resultado"),
            fontSize = 64.sp,
            textAlign = TextAlign.End,
            fontWeight = FontWeight.Light,
            lineHeight = 70.sp
        )

        val botones = listOf(
            listOf("C", "±", "%", "/"),
            listOf("7", "8", "9", "*"),
            listOf("4", "5", "6", "-"),
            listOf("1", "2", "3", "+"),
            listOf("0", ".", "=")
        )

        botones.forEach { fila ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                fila.forEach { texto ->
                    val esOperador = texto in listOf("/", "*", "-", "+", "=")
                    val esEspecial = texto in listOf("C", "±", "%")
                    
                    val colorFondo = when {
                        esOperador -> MaterialTheme.colorScheme.primary
                        esEspecial -> MaterialTheme.colorScheme.secondaryContainer
                        else -> MaterialTheme.colorScheme.surfaceVariant
                    }
                    
                    val colorTexto = when {
                        esOperador -> MaterialTheme.colorScheme.onPrimary
                        esEspecial -> MaterialTheme.colorScheme.onSecondaryContainer
                        else -> MaterialTheme.colorScheme.onSurfaceVariant
                    }

                    Button(
                        onClick = {
                            when {
                                texto == "C" -> {
                                    expresion = "0"
                                    primerOperando = null
                                    operacionPendiente = null
                                    nuevoNumero = true
                                }
                                texto == "=" -> calcular()
                                texto in listOf("+", "-", "*", "/") -> onOperacionClick(texto)
                                texto == "." -> if ("." !in expresion) expresion += "."
                                else -> if (texto.all { it.isDigit() }) onNumeroClick(texto)
                            }
                        },
                        modifier = Modifier
                            .weight(if (texto == "0") 2f else 1f)
                            .aspectRatio(if (texto == "0") 2f else 1f)
                            .padding(bottom = 12.dp),
                        shape = CircleShape,
                        colors = ButtonDefaults.buttonColors(containerColor = colorFondo, contentColor = colorTexto),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Text(text = texto, fontSize = 24.sp, fontWeight = FontWeight.Medium)
                    }
                }
            }
        }
    }
}
