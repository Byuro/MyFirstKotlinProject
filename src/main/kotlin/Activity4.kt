fun main() {
    while (true) {
        println("--------------------------------------------------")
        println("1. Enter equipment")
        println("2. Add equipment")
        println("3. Exit")
        println("--------------------------------------------------")
        println("Enter choice")
        val choice = readLine()!!.toInt()
        when (choice) {
            1 -> {
                println("Enter equipment name: ")
                var name = readLine()
                println("--------------------------------------------------")
                println("Condition of item: ")
                var cond = readLine()
                println("--------------------------------------------------")
                println("Enter equipment quantity: ")
                val quantity = readLine()!!.toInt()
                println("--------------------------------------------------")
                println("Your Inventory Equipment:$name Quality:$quantity Condition:$cond")

            }
            2 -> {
                println("Enter equipment name: ")
                val name = readLine()
                println("--------------------------------------------------")
                println("Condition of item: ")
                var cond = readLine()
                println("--------------------------------------------------")
                println("Enter equipment quantity: ")
                val quantity = readLine()!!.toInt()
                println("--------------------------------------------------")
                println("Your Inventory Equipment:$name Quality:$quantity Condition:$cond")

            }

            3 ->{println("THANK YOU!")
                break
            }
            else -> {
                println("Invalid choice")
            }
        }
    }
}
