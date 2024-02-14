fun main () {

    while (true) {
    println("Enter the name of the student: ")
    val namestudents: String? = readlnOrNull()


        println("Enter name of student grades. ")
        println ("English: ")
        val english = readlnOrNull()?.toInt()?:0
        println ("Math: ")
        val math = readlnOrNull()?.toInt()?:0
        println ("Science: ")
        val science = readlnOrNull()?.toInt()?:0
        println ("Filipino: ")
        val filipino = readlnOrNull()?.toInt()?:0

        val ans = english+math+science+filipino
        val average = ans / 4
        println("Your Name is $namestudents")
        println("Student grades")
        println("English: $english")
        println("Math: $math ")
        println("Science: $science")
        println("Filipino: $filipino")
        println("total average grade: $average")



    }
}