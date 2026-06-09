package ni.edu.uam.pruebasunitarias

import org.junit.Assert.assertEquals
import org.junit.Test

class CalculadoraTest {
    private val calculadora = Calculadora()

    @Test
    fun verificarSuma() {
        assertEquals(8, calculadora.sumar(5, 3))
    }

    // --- Actividades Complementarias ---

    @Test
    fun verificarResta() {
        assertEquals(6, calculadora.restar(10, 4))
    }

    @Test
    fun verificarMultiplicacion() {
        assertEquals(15, calculadora.multiplicar(5, 3))
    }

    @Test
    fun verificarDivision() {
        assertEquals(2, calculadora.dividir(10, 5))
    }

    @Test
    fun verificarNumerosNegativos() {
        // Validando el comportamiento ante números negativos
        assertEquals(-2, calculadora.sumar(-5, 3))
        assertEquals(-15, calculadora.multiplicar(-5, 3))
    }

    @Test
    fun pruebaFalloIntencional() {
        // Esta prueba fallará intencionalmente.
        // Causa: Esperamos que 5 + 3 sea 10, pero la lógica devolverá 8.
        assertEquals(10, calculadora.sumar(5, 3)) 
    }
}
