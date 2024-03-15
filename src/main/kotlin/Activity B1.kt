import mu.KotlinLogging
import java.time.LocalDate
import java.time.format.DateTimeFormatter

private val logger = KotlinLogging.logger {}

data class BorrowedBook(
    var borrower: String,
    var book: String,
    val dateBorrowed: LocalDate,
    val daysToBorrow: Long,
    var course: String,
    val schoolId: String,
    var returned: Boolean = false
)

fun main() {
    var option: Int
    var borrowedBooks: ArrayList<BorrowedBook> = ArrayList()

    val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    do {
        println(
            """
            ---------------------------
            | Please select your Menu |
            ---------------------------
            [1] Add new 
            [2] Update 
            [3] Return 
            [4] Display 
            [5] Exit
            -----------------------------
        """.trimIndent()
        )


        print("Enter your choice: ")

        option = readLine()?.toIntOrNull() ?: 1
        println("-------------------------------------")

        when (option) {
            1 -> addNew(borrowedBooks)
            2 -> update(borrowedBooks)
            3 -> returnInfo(borrowedBooks)
            4 -> display(borrowedBooks, dateFormatter)
            5 -> {
                logger.info("Exiting program...")
                println("Exiting program...")

            }
            else -> println("Invalid menu. Please try again.")
        }
    } while (option != 5)

}

fun addNew(borrowedBooks: ArrayList<BorrowedBook>) {

    println("Enter Borrower name:")
    val borrower = readLine() ?: ""

    println("Enter the title of the book:")
    val book = readLine() ?: ""

    println("Enter department:")
    val course = readLine() ?: ""

    println("Enter Student's ID: ")
    val schoolId = readLine() ?: ""

    println("Enter a Number of days to borrow:")
    val daysToBorrow = readLine()?.toLongOrNull() ?: 2

    println("Do you really want to borrow the book? Press [1] Yes, [2] No")
    val confirmInput = readLine()?.toUpperCase() ?: ""

    if (confirmInput == "1") {
        println("Data has been successfully saved!")
        val newBook = BorrowedBook(
            borrower.toUpperCase(),
            book.toUpperCase(),
            LocalDate.now(),
            daysToBorrow,
            course.toUpperCase(),
            schoolId
        )
        borrowedBooks.add(newBook)
        logger.info("New book added: $newBook")
    } else {
        println("Transaction canceled.")
        logger.info("Transaction canceled.")
    }
}

fun update(borrowedBooks: ArrayList<BorrowedBook>) {
    if (borrowedBooks.isEmpty()) {
        println("No transaction to update.")
        logger.warn("Attempted to update with no transactions.")
        return
    }

    println("Enter the index of the list you want to update:")
    val index = readLine()?.toIntOrNull()

    if (index == null || index !in 0 until borrowedBooks.size) {
        println("Invalid index.")
        logger.warn("Invalid index provided for update.")
        return
    }

    val currentList  = borrowedBooks[index]

    println("Current info:")
    displayItem(currentList)

    println("Enter new info:")

    println("Enter Borrower name:")
    val borrower = readLine() ?: currentList.borrower

    println("Enter the title of the book:")
    val book = readLine() ?: currentList.book

    println("Enter department:")
    val course = readLine() ?: currentList.course

    println("Enter School ID: ")
    val schoolId = readLine() ?: currentList.schoolId

    println("Enter a Number of days to borrow:")
    val daysToBorrow = readLine()?.toLongOrNull() ?: currentList.daysToBorrow

    borrowedBooks[index] = BorrowedBook(
        borrower,
        book,
        currentList.dateBorrowed,
        daysToBorrow,
        course,
        schoolId
    )
    println("transaction updated successfully!")
    logger.info("Transaction updated: $currentList -> ${borrowedBooks[index]}")
}

fun returnInfo(borrowedBooks: ArrayList<BorrowedBook>) {
    if (borrowedBooks.isEmpty()) {
        println("No books to return.")
        logger.warn("Attempted to return with no books.")
        return
    }

    println("Enter the index of the book you want to return:")
    val index = readLine()?.toIntOrNull()

    if (index == null || index !in 0 until borrowedBooks.size) {
        println("Invalid index.")
        logger.warn("Invalid index provided for return.")
        return
    }

    val returnedBook = borrowedBooks[index]

    if (returnedBook.returned) {
        println("This book has already been returned.")
        logger.warn("Attempted to return an already returned book.")
        return
    }

    returnedBook.returned = true
    println("Book returned successfully!")
    logger.info("Book returned: $returnedBook")
}

fun display(list: ArrayList<BorrowedBook>, dateFormatter: DateTimeFormatter) {
    println("List of Borrowed")
    println("INDEX --> NAME | BOOK | DATE BORROWED | DATE RETURN | DURATION (DAYS) | COURSE | SCHOOL ID | RETURNED")
    println("----------------------------------------------------------------------------------------------------------------------------------")

    if (list.isEmpty()) {
        println("There's no record yet added.")
        logger.info("No transaction to display.")
        return
    }

    for ((index, data ) in list.withIndex()) {
        println(
            "$index\t | ${data.borrower} | ${data.book} | ${
                data.dateBorrowed.format(
                    dateFormatter
                )
            } | ${data.dateBorrowed.plusDays(data.daysToBorrow).format(dateFormatter)} | ${data.daysToBorrow} | ${data.course} | ${data.schoolId} | ${if (data.returned) "Yes" else "No"}"
        )
    }
}

fun displayItem(data: BorrowedBook) {
    println("INDEX --> NAME      |    BOOK    |   DATE BORROWED   |     DATE RETURN     |   DURATION (DAYS)   |     COURSE     |    SCHOOL ID | RETURNED")
    println("----------------------------------------------------------------------------------------------------------------------------------")
    println(
        "${data.borrower}   |  ${data.book}    |     ${
            data.dateBorrowed.format(
                DateTimeFormatter.ofPattern("yyyy-MM-dd")
            )
        } |     ${
            data.dateBorrowed
                .atStartOfDay()
                .plusDays(data.daysToBorrow)
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        }   |     ${data.daysToBorrow}    |   ${data.course}    |   ${data.schoolId}   |   ${if (data.returned) "Yes" else "No"}"
    )
}

