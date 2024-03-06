fun main(){
    var word1: String? = ""
    var word2: String? = ""
    var uniq1: String? = ""
    var uniq2: String? = ""
    var uniq3: String? = ""



    println(" First String: ")
    word1 = readLine()
    println(" Second String: ")
    word2 = readLine()

    for (i in word1!!.indices){
        var flag = true
        for(j in word1.indices){
            if(word1[i] == word1[j] && i != j ){
                flag = false
                break
            }
        }
        if(flag == true) uniq1 += word1[i]
    }
    println("$word1 unique character: $uniq1")

    for (a in word2!!.indices){
        var flag = true
        for(c in word2.indices){
            if(word2[a] == word2[c] && a != c ){
                flag = false
                break
            }
        }
        if(flag == true) uniq2 += word2[a]
    }
    println(println("$word2 unique character: $uniq2"))

    var buniq = uniq1 + uniq2

    for (d in buniq!!.indices){
        var flag = true
        for(f in buniq.indices){
            if(buniq[d] == buniq[f] && d != f ){
                flag = false
                break
            }
        }
        if(flag == true) uniq3 += buniq[d]
    }
    println(println("unique character of both unique character: $uniq3"))
}