fun main()
{
    while (true)
    {
        println("Enter the first string:")
        val String1 = readLine()!!.toString()

        println("Enter the second string:")
        val String2 = readLine()!!.toString()

        val uniqueChars = String1.toSet() intersect String2.toSet()

        println("Unique characters in both strings: $uniqueChars")
        println("You want to do more? [1] Yes [2] No ")
        val ans = readLine()!!.toInt()
        if (ans == 1)
        {
            continue
        }
        else
        {
            println("Thank you!!")
            break
        }
    }
}