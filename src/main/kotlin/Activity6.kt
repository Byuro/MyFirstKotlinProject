fun main() {
    while (true) {
        println("Enter the first string:")
        val string1 = readLine()!!.toString()

        println("Enter the second string:")
        val string2 = readLine()!!.toString()

        // gi set nako ang input string into set of unique characters
        val set1 = string1.toSet()
        val set2 = string2.toSet()

        // nag gamit kog intersect para ma combine niya ang String input 1 and 2 nga na set na into unique characters
        // ang purpose sa subtract is para i remove niya tong nag duplicate nga letters or characters inig mag intersect na ang 2 input string
        val uniquechacter = (set1 + set2).subtract(set1.intersect(set2))

        println("Input1: $string1")
        println("Input2: $string2")
        println("Unique character in both string: $uniquechacter")
        println("You want to do more? [1] Yes [2] No ")
        val ans = readLine()!!.toInt()
        if (ans == 1) {
            continue
        } else {
            println("Thank you!!")
            break
        }
    }
}