import mu.KotlinLogging
import java.time.LocalDate
import java.time.format.DateTimeFormatter
val logger = KotlinLogging.logger {}

data class BorrowedItem(
    val borrower: String,
    val book: String,
    val dateBorrowed: LocalDate,
    val daysToBorrow: Long,
    val course: String,
    val schoolId: String
)

fun main() {
    var option: Int
    val borrowedItems: ArrayList<BorrowedItem> = ArrayList()

    val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    do {
        println(
            """
            -----------------------------
              Please select your option 
            -----------------------------
            [1] Add new Borrower
            [2] Update Information
            [3] Display Borrower
            [4] Exit
            -----------------------------
        """.trimIndent()
        )


        print("Enter your choice: ")
        option = readLine()?.toIntOrNull() ?: 1
        println("-------------------------------------")

        when (option) {
            1 -> addNewItem(borrowedItems)
            2 -> updateItem(borrowedItems)
            3 -> displayItems(borrowedItems, dateFormatter)
            4 -> {
                println("Exiting program...")
                logger.info("Exiting program...")
            }
            else -> println("Invalid option. Please try again.")
        }
    } while (option != 4)
}

fun addNewItem(borrowedItems: ArrayList<BorrowedItem>) {
    println("Enter Borrower's name:")
    val borrower = readLine() ?: ""

    println("Enter title of the book:")
    val book = readLine() ?: ""

    println("Enter department:")
    val course = readLine() ?: ""

    println("Enter Student ID: ")
    val schoolId = readLine() ?: ""

    println("Enter a Number of days you wanna borrow:")
    val daysToBorrow = readLine()?.toLongOrNull() ?: 2

    println("Do you really want to borrow the book? [Y/N]")
    val confirmInput = readLine()?.toUpperCase() ?: ""

    if (confirmInput == "Y") {
        println("Data has been successfully saved!")
        val newItem = BorrowedItem(
            borrower.toUpperCase(),
            book.toUpperCase(),
            LocalDate.now(),
            daysToBorrow,
            course.toUpperCase(),
            schoolId
        )
        borrowedItems.add(newItem)
        logger.info("New item added: $newItem")
    } else {
        println("Transaction canceled.")
        logger.info("Transaction canceled.")
    }
}

fun updateItem(borrowedItems: ArrayList<BorrowedItem>) {
    if (borrowedItems.isEmpty()) {
        println("No items to update.")
        logger.warn("Attempted to update with no items.")
        return
    }

    println("Enter the index of the item you want to update:")
    val index = readLine()?.toIntOrNull()

    if (index == null || index !in 0 until borrowedItems.size) {
        println("Invalid index.")
        logger.warn("Invalid index provided for update.")
        return
    }

    val currentItem = borrowedItems[index]

    println("Current details:")
    displayItem(currentItem)

    println("Enter new details:")

    println("Enter Borrower's name:")
    val borrower = readLine() ?: currentItem.borrower

    println("Enter title of the book:")
    val book = readLine() ?: currentItem.book

    println("Enter department:")
    val course = readLine() ?: currentItem.course

    println("Enter School ID: ")
    val schoolId = readLine() ?: currentItem.schoolId

    println("Enter a Number of days you wanna borrow:")
    val daysToBorrow = readLine()?.toLongOrNull() ?: currentItem.daysToBorrow

    borrowedItems[index] = BorrowedItem(
        borrower,
        book,
        currentItem.dateBorrowed,
        daysToBorrow,
        course,
        schoolId
    )
    println("Item updated successfully!")
    logger.info("Item updated: $currentItem -> ${borrowedItems[index]}")
}

fun displayItems(items: ArrayList<BorrowedItem>, dateFormatter: DateTimeFormatter) {
    println("List of Borrowed")
    println("INDEX --> NAME      |    BOOK    |   DATE BORROWED   |     DATE RETURN     |   DURATION (DAYS)   |     COURSE     |    SCHOOL ID")
    println("----------------------------------------------------------------------------------------------------------------------------------")

    if (items.isEmpty()) {
        println("There's no record yet added.")
        logger.info("No items to display.")
        return
    }

    for ((index, item) in items.withIndex()) {
        println(
            "$index\t | ${item.borrower} | ${item.book} | ${
                item.dateBorrowed.format(
                    dateFormatter
                )
            } | ${item.dateBorrowed.plusDays(item.daysToBorrow).format(dateFormatter)} | ${item.daysToBorrow} | ${item.course} | ${item.schoolId}"
        )
    }
}

fun displayItem(item: BorrowedItem) {
    println("INDEX --> NAME      |    BOOK    |   DATE BORROWED   |     DATE RETURN     |   DURATION (DAYS)   |     COURSE     |    SCHOOL ID")
    println("----------------------------------------------------------------------------------------------------------------------------------")
    println(
        "${item.borrower}   |  ${item.book}    |     ${
            item.dateBorrowed.format(
                DateTimeFormatter.ofPattern("yyyy-MM-dd")
            )
        } |     ${
            item.dateBorrowed
                .atStartOfDay()
                .plusDays(item.daysToBorrow)
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        }   |     ${item.daysToBorrow}    |   ${item.course}    |   ${item.schoolId}"
    )
}
