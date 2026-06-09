package ni.edu.uam.pruebasunitarias

import org.junit.Assert.assertEquals
import org.junit.Test

class CalculadoraTest {
    private val calculadora = Calculadora()

    @Test
    fun verificarSuma() {
        assertEquals(8.0, calculadora.sumar(5.0, 3.0), 0.001)
    }

    // --- Actividades Complementarias ---

    @Test
    fun verificarResta() {
        assertEquals(6.0, calculadora.restar(10.0, 4.0), 0.001)
    }

    @Test
    fun verificarMultiplicacion() {
        assertEquals(15.0, calculadora.multiplicar(5.0, 3.0), 0.001)
    }

    @Test
    fun verificarDivision() {
        assertEquals(2.0, calculadora.dividir(10.0, 5.0), 0.001)
    }

    @Test
    fun verificarNumerosNegativos() {
        // Validando el comportamiento ante números negativos
        assertEquals(-2.0, calculadora.sumar(-5.0, 3.0), 0.001)
        assertEquals(-15.0, calculadora.multiplicar(-5.0, 3.0), 0.001)
    }

    @Test
    fun pruebaFalloIntencional() {
        // Esta prueba fallará intencionalmente.
        // Causa: Esperamos que 5 + 3 sea 10, pero la lógica devolverá 8.
        assertEquals(10.0, calculadora.sumar(5.0, 3.0), 0.001)
    }
}
