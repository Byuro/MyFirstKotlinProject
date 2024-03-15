package org.example

import mu.KotlinLogging

class Logging {
    companion object {
        private val logger = KotlinLogging.logger {}
        fun log() = logger
    }
}

class HotelReservation {
    private val bookings = mutableMapOf<Int, MutableMap<String, Any>>()
    private val availableRooms = mutableMapOf<Int, String>()

    init {
        // Initialize available room types
        availableRooms[1] = "Standard Room"
        availableRooms[2] = "Deluxe Room"
        availableRooms[3] = "Suite"
    }

    fun addBooking(customerName: String, roomId: Int, checkInDate: String, checkOutDate: String) {
        val bookingDetails = mutableMapOf<String, Any>(
            "customerName" to customerName,
            "roomId" to roomId,
            "checkInDate" to checkInDate,
            "checkOutDate" to checkOutDate,
            "isPaid" to false // Payment status initially set to false
        )
        bookings[roomId] = bookingDetails
        println("Booking added successfully.")
    }

    fun displayAvailableRooms() {
        println("[ AVAILABLE ROOMS ]")
        println("-------------------------------")
        availableRooms.forEach { (roomId, roomType) ->
            println("Room ID: $roomId | Room Type: $roomType")
        }
        println("-------------------------------")
    }

    fun cancelBooking(bookingId: Int) {
        if (bookings.containsKey(bookingId)) {
            bookings.remove(bookingId)
            println("Booking canceled successfully.")
        } else {
            println("Booking not found.")
        }
    }

    fun updateBooking(bookingId: Int, updatedCheckInDate: String, updatedCheckOutDate: String) {
        if (bookings.containsKey(bookingId)) {
            val booking = bookings[bookingId]!!
            booking["checkInDate"] = updatedCheckInDate
            booking["checkOutDate"] = updatedCheckOutDate
            println("Booking updated successfully.")
        } else {
            println("Booking not found.")
        }
    }

    fun payBooking(bookingId: Int) {
        if (bookings.containsKey(bookingId)) {
            val booking = bookings[bookingId]!!
            booking["isPaid"] = true
            println("Booking marked as paid.")
        } else {
            println("Booking not found.")
        }
    }

    fun displayBookings() {
        println("----------------------------------------------------------------------------------")
        println("INDEX | CUSTOMER NAME | ROOM ID | CHECK-IN DATE | CHECK-OUT DATE | PAYMENT STATUS")
        println("----------------------------------------------------------------------------------")

        if (bookings.isEmpty()) {
            println("No bookings found.")
        } else {
            bookings.values.forEachIndexed { index, booking ->
                val customerName = booking["customerName"]
                val roomId = booking["roomId"]
                val checkInDate = booking["checkInDate"]
                val checkOutDate = booking["checkOutDate"]
                val paymentStatus = if (booking["isPaid"] == true) "Paid" else "Not Paid"

                println(
                    String.format(
                        "%-6s| %-14s| %-8s| %-14s| %-15s| %-13s",
                        index,
                        customerName,
                        roomId,
                        checkInDate,
                        checkOutDate,
                        paymentStatus
                    )
                )
            }
        }
        println("----------------------------------------------------------------------------------")
    }
}

fun main() {
    val hotelReservation = HotelReservation()

    do {
        println(
            """
            ----------------------------
            | HOTEL RESERVATION SYSTEM |
            ----------------------------
            [1] Display available rooms
            [2] Add booking
            [3] Cancel booking
            [4] Update booking
            [5] Pay booking // Option for paying a booking
            [6] Display bookings
            [7] Exit
            Enter your choice:
        """.trimIndent()
        )

        var option: Int
        try {
            option = readLine()?.toInt() ?: 7
        } catch (e: Exception) {
            Logging.log().error { "Invalid input: $e" }
            option = 7
        }


        when (option) {
            1 -> hotelReservation.displayAvailableRooms()
            2 -> addBooking(hotelReservation)
            3 -> cancelBooking(hotelReservation)
            4 -> updateBooking(hotelReservation)
            5 -> payBooking(hotelReservation) // Call payBooking function
            6 -> hotelReservation.displayBookings()
            7 -> {
                println("Exiting...")
                return
            }

            else -> println("Invalid option")
        }
    } while (true)
}

fun addBooking(hotelReservation: HotelReservation) {
    println("Enter customer name:")
    val customerName = readLine()

    println("Enter room ID:")
    val roomId = try {
        readLine()?.toInt() ?: 0
    } catch (e: Exception) {
        Logging.log().error { "Invalid room ID: $e" }
        0
    }

    println("Enter check-in date (YYYY-MM-DD):")
    val checkInDate = readLine()

    println("Enter check-out date (YYYY-MM-DD):")
    val checkOutDate = readLine()

    hotelReservation.addBooking(customerName!!, roomId, checkInDate!!, checkOutDate!!)
}

fun cancelBooking(hotelReservation: HotelReservation) {
    println("Enter booking ID to cancel:")
    val bookingId = try {
        readLine()?.toInt() ?: 0
    } catch (e: Exception) {
        Logging.log().error { "Invalid booking ID: $e" }
        0
    }

    hotelReservation.cancelBooking(bookingId)
}

fun updateBooking(hotelReservation: HotelReservation) {
    println("Enter booking ID to update:")
    val bookingId = try {
        readLine()?.toInt() ?: 0
    } catch (e: Exception) {
        Logging.log().error { "Invalid booking ID: $e" }
        0
    }

    println("Enter updated check-in date (YYYY-MM-DD):")
    val updatedCheckInDate = readLine()

    println("Enter updated check-out date (YYYY-MM-DD):")
    val updatedCheckOutDate = readLine()

    hotelReservation.updateBooking(bookingId, updatedCheckInDate!!, updatedCheckOutDate!!)
}

fun payBooking(hotelReservation: HotelReservation) {
    println("Enter booking ID to pay:")
    val roomId = try {
        readLine()?.toInt() ?: 0
    } catch (e: Exception) {
        Logging.log().error { "Invalid booking ID: $e" }
        0
    }

    hotelReservation.payBooking(roomId)
}

