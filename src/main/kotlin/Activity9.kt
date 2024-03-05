fun main() {
    print("Enter integer: ")
    val number = readLine()!!.toInt()

    if (number < 0) {
        println("Invalid input!")
        return
    }

    var result = ""
    var product = 1

    for (i in number downTo 1) {
        product *= i
        if (i == number) {
            result += "$i"
        } else {
            result += "x$i"
        }
    }
    println("Factorial of $number is: $result=$product")
}
