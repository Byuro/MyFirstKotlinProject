fun main() {
    while (true) {
        println("--------------------------------------------------")
        println("1.borrow book")
        println("2. Exit")
        println("--------------------------------------------------")
        println("Enter choice")
        val choice = readLine()!!.toInt()
        when (choice) {
            1 -> {
                println("Enter student's name: ")
                var name = readLine()
                println("--------------------------------------------------")
                println("Enter Student's ID: ")
                var id = readLine()
                println("--------------------------------------------------")
                println("Enter Department: ")
                var dep = readLine()
                println("--------------------------------------------------")
                println("Enter Book Title: ")
                var title = readLine()
                println("--------------------------------------------------")
                println("IS THIS AVAILABLE [YES]||[NO]: ")
                var avail = readLine()

                println("--------------------------------------------------")
                println("Your Borrowd book:$name "+
                        "Id:$id "+
                        "Department:$dep"+
                        "Title:$title"+
                        "Availability:$avail")


            }
            2 ->{println("THANK YOU!")
                break
            }
            else -> {
                println("Invalid choice")
            }
        }
    }
}
