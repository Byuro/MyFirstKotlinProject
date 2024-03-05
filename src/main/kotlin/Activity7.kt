fun main() {
    while (true) {
        println("Enter a string:")
        val inputString = readLine()!!

        val cleanString = inputString.filter { it.isLetterOrDigit() }.toLowerCase()

        if (cleanString == cleanString.reversed()) {
            println("Palindrome")
        } else {
            println("Not a Palindrome")
        }
    }
}