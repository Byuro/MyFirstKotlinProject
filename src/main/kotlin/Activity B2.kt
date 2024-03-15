import mu.KotlinLogging

class Logging {
    companion object {
        private val logger = KotlinLogging.logger {}
        fun log() = logger
    }
}

fun main() {
    var totalCost: Double
    val cart = mutableMapOf<Int, MutableMap<String, Any>>()

    do {
        println(
            """
            ---------------------------
            | WELCOME TO UNIQLO SHOP |
            ---------------------------
            [1] Add item to cart
            [2] Display item
            [3] Checkout
            [4] Exit
            Enter your choice:
        """.trimIndent()
        )

        var index = cart.size + 1
        var option: Int
        try {
            option = readLine()?.toInt() ?: 4
        } catch (e: Exception) {
            Logging.log().error { "Invalid input: $e" }
            option = 4
        }

        when (option) {
            1 -> addItemToCart(cart, index++)
            2 -> displayCart(cart)
            3 -> { displayCart(cart)
                totalCost = cart.values.sumByDouble { it["totalCost"] as Double }

                println("Total number of items: ${cart.size}")
                println("Total Cost: ₱$totalCost")
                println("Thank you for shopping with us!")
                break
            }
            4 -> {
                println("Exiting...")
                return
            }
            else -> println("Invalid option")
        }
    } while (true)

}

fun addItemToCart(cart: MutableMap<Int, MutableMap<String, Any>>, index: Int) {
    println("Enter item name:")
    val itemName = readLine()

    println("Enter quantity:")
    val quantity = try {
        readLine()?.toInt() ?: 1
    } catch (e: Exception) {
        Logging.log().error { "Invalid quantity: $e" }
        1
    }

    println("Enter price per item:")
    val pricePerItem = try {
        readLine()?.toDouble() ?: 0.0
    } catch (e: Exception) {
        Logging.log().error { "Invalid price: $e" }
        0.0
    }

    val totalItemCost = quantity * pricePerItem
    val itemDetails = mutableMapOf<String, Any>(
        "itemName" to itemName!!,
        "quantity" to quantity,
        "pricePerItem" to pricePerItem,
        "totalCost" to totalItemCost
    )
    cart[index] = itemDetails

    println("Item added to cart.")
}

fun displayCart(cart: Map<Int, Map<String, Any>>) {
    println("[ CART ITEMS ]")
    println("-----------------------------------------------------------")

    if (cart.isEmpty()) {
        println("Cart is empty.")
    } else {
        cart.forEach { (index, item) ->
            println("Index: $index")
            println("Item name: ${item["itemName"]}")
            println("Quantity: ${item["quantity"]}")
            println("Price per item: ₱${item["pricePerItem"]}")
            println("Total cost: ₱${item["totalCost"]}")
            println("----------------------------------------------------")
        }
    }
}




