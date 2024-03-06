fun main() {
    println("Enter first string: ")
    var word1: String? = readLine()

    println("Enter second string: ")
    var word2: String? = readLine()

    val uniq1 = findUniqueCharacters(word1)
    println("$word1 unique characters: $uniq1")

    val uniq2 = findUniqueCharacters(word2)
    println("$word2 unique characters: $uniq2")

    val uniq3 = findUniqueCharacters(uniq1 + uniq2)
    println("Unique characters of both strings: $uniq3")
}

fun findUniqueCharacters(input: String?): String
{
    return input?.let { it.filter { char -> it.count { c -> c == char } == 1 } } ?: ""
}
