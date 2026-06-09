package ni.edu.uam.pruebasunitarias

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

class PantallaCalculadoraTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun verificarBotonYResultado() {
        composeTestRule.setContent { PantallaCalculadora() }

        // Interactuar con el botón principal (Paso 9)
        composeTestRule.onNodeWithText("Calcular").performClick()

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
