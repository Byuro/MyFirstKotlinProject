fun main() {
    println("Enter the first integer:")
    val num1 = readLine()!!.toInt()

    println("Enter the second integer:")
    val num2 = readLine()!!.toInt()

    val (lower, higher) = if (num1 < num2) num1 to num2 else num2 to num1

    println("Prime numbers between $lower and $higher:")
    (lower..higher).filter { isPrime(it) }.joinToString(", ").let(::println)
}

fun isPrime(num: Int): Boolean =
    num > 1 && (2 until num).none { num % it == 0 }
