fun main()
{
    while (true)
    {
        print("Enter number: ")
        val num = readln().toIntOrNull()!!.toInt()

        if (num % 2 == 0) {
            println("$num is Even: " + (num downTo 2 step 2).joinToString(", "))
        }
        else if(num >= 1)
        {
            println("$num is Odd:" + (num downTo 1 step 2).joinToString(", "))
        }
        else
        {
            println("Invalid number")
        }
    }
}