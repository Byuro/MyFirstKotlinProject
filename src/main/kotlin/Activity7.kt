fun main() {
    while (true) {
        var pword: String? = ""
        var palin: String? = ""

        println("Enter Word: ")
        val word = readLine()
        for (i in 0 until word!!.length) {
            pword += word[i].toString().trim()
        }

        for (i in pword!!.length - 1 downTo 0) {
            palin += pword[i].toString().trim()
        }

        if (pword.trim() == palin) {
            println("The word $word is a palindrome.")
        } else {
            println("The word $word is not a palindrome.")
        }

    }
}
