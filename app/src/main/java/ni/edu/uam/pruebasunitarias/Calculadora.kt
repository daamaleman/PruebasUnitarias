package ni.edu.uam.pruebasunitarias

class Calculadora {
    fun sumar(a: Int, b: Int): Int = a + b
    fun restar(a: Int, b: Int): Int = a - b
    fun multiplicar(a: Int, b: Int): Int = a * b
    fun dividir(a: Int, b: Int): Int {
        require(b != 0) { "No se puede dividir por cero" }
        return a / b
    }
}
