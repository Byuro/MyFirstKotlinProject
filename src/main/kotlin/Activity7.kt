fun main()
{
    while (true) {
        println("Enter a string:")
        val inputString = readLine()!!

        if (isPalindrome(inputString)) {
            println("Palindrome")
        }
        else
        {
            println("Not a Palindrome")
        }
    }

}
fun isPalindrome(str: String) = str.filter { it.isLetterOrDigit() }.toLowerCase() == str.filter { it.isLetterOrDigit() }.reversed()
