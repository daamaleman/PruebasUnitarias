package ni.edu.uam.pruebasunitarias

class Calculadora {
    fun sumar(a: Double, b: Double): Double = a + b
    fun restar(a: Double, b: Double): Double = a - b
    fun multiplicar(a: Double, b: Double): Double = a * b
    fun dividir(a: Double, b: Double): Double {
        require(b != 0.0) { "No se puede dividir por cero" }
        return a / b
    }
}
