fun main(){
    //Acitvity 11

    print("Enter percentage: ")
    val percentage = readLine()!!.toDouble()

    println("Enter a value to get percentage: ")
    val value = readLine()!!.toDouble()

    val decimalPercentage = percentage / 100
    val result = decimalPercentage * value

    println("Answer $result")


}