fun main() {
    println("Enter two integers separated by a space:")
    val (num1, num2) = readLine()!!.split(" ").map { it.toInt() }

    val (lower, higher) = minOf(num1, num2) to maxOf(num1, num2)

    val primes = (lower..higher).filter { candidate ->
        candidate > 1 && (2 until candidate).none { candidate % it == 0 }
    }.joinToString(", ")

    println("Prime numbers between $lower and $higher: $primes")
}
