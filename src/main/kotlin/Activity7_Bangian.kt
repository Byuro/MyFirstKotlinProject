package src.main.kotlin

fun main() {
    do {
        var pword: String? = ""
        var palin: String? = ""

        println("Enter Word: ")
        val word = readLine()
        for (i in 0.. word!!.length-1 ){
            pword += word.get(i).toString().trim()
        }

        for (i in pword!!.length - 1 downTo 0) {
            palin += pword[i].toString().trim()
        }
        //println(palin)

        if (pword.trim() == palin) {
            println("the word $word is palindrome ")
        } else {
            println("the word $word is not palindrome ")
        }

        print("DO YOU WANT TO CONTINUE [Yes] IF YES, [No] IF NO: ")
    } while (readLine()?.equals("yes", ignoreCase = true) == true)

    println("Arigatou Gozaimasu!")
}
