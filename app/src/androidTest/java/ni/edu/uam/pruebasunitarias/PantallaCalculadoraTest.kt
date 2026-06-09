package ni.edu.uam.pruebasunitarias

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

class PantallaCalculadoraTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun verificarBotonSumaYResultado() {
        composeTestRule.setContent { PantallaCalculadora() }

        // Interactuar con el primer botón
        composeTestRule.onNodeWithText("Sumar (5+3)").performClick()

        // Validar el resultado
        composeTestRule.onNodeWithTag("resultado").assertTextEquals("8")
    }

    @Test
    fun verificarBotonRestaYResultado() {
        composeTestRule.setContent { PantallaCalculadora() }

        // Actividad complementaria: Interactuar con el segundo botón
        composeTestRule.onNodeWithText("Restar (10-4)").performClick()

        // Validar el resultado
        composeTestRule.onNodeWithTag("resultado").assertTextEquals("6")
    }
}
