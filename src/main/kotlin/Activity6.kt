fun main(){
    println("Enter string")
    var string1: String? = readln()

    println("Enter string")
    var string2: String? = readln()

    val uniq1 = findUniqueCharacters(string1)
    println("Unique character: $uniq1")

    val uniq2 = findUniqueCharacters(string2)
    println("Unique character: $uniq2")

    val combine = findUniqueCharacters(string1 + string2)
    println("Combine Unique characters: $combine")

    val total =(string1?.length!! - uniq1.length)
    println("$total")
    val total2 =(string2?.length!! - uniq2.length)
    println("$total2")
    val total3 =(total+total2)
    print("$total3")




}
fun findUniqueCharacters(input:String?):String{
    return input?.let { it.filter { char -> it.count { c-> c==char }==1 }}?:" "
}