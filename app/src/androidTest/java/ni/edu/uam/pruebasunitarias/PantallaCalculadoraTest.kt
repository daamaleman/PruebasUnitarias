package ni.edu.uam.pruebasunitarias

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

class PantallaCalculadoraTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun verificarSumaCompleta() {
        composeTestRule.setContent { PantallaCalculadora() }

        // Realizar 5 + 3 = 8
        composeTestRule.onNodeWithText("5").performClick()
        composeTestRule.onNodeWithText("+").performClick()
        composeTestRule.onNodeWithText("3").performClick()
        composeTestRule.onNodeWithText("=").performClick()

        // Validar el resultado
        composeTestRule.onNodeWithTag("resultado").assertTextEquals("8")
    }

    @Test
    fun verificarLimpiarPantalla() {
        composeTestRule.setContent { PantallaCalculadora() }

        // Escribir algo y luego limpiar
        composeTestRule.onNodeWithText("9").performClick()
        composeTestRule.onNodeWithText("C").performClick()

        // El display debe volver a 0
        composeTestRule.onNodeWithTag("resultado").assertTextEquals("0")
    }

    @Test
    fun verificarRestaCompleta() {
        composeTestRule.setContent { PantallaCalculadora() }

        // Realizar 10 - 4 = 6
        composeTestRule.onNodeWithText("1").performClick()
        composeTestRule.onNodeWithText("0").performClick()
        composeTestRule.onNodeWithText("-").performClick()
        composeTestRule.onNodeWithText("4").performClick()
        composeTestRule.onNodeWithText("=").performClick()

        // Validar el resultado
        composeTestRule.onNodeWithTag("resultado").assertTextEquals("6")
    }
}
