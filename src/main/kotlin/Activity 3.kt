fun main() {
    do {


        println("Enter your name:")
        val name = readLine()
        println("---------------------------------------------------------------")
        println("Enter age:")
        val age = readLine()!!.toInt()
        println("---------------------------------------------------------------")


        if (age < 1) {
            println("INVALID")
        }
        else
        {
            when (age)
            {
                in 1..17 -> println("$name is Under Age")
                in 18..30 -> println("$name is Young Age")
                in 31..59 -> println("$name is Adult")
                in 60..120 -> println("$name is Senior")
<<<<<<< HEAD
                else -> println("$name Invalid Age")
=======
                else -> println("Invalid")
>>>>>>> origin/master

            }

        }
    }while (true)
}