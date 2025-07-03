package com.yogesh.cohort3


/*Dear Students,

Please complete the following assignment to understand and apply key Kotlin concepts: interfaces, visibility modifiers, extension functions and properties, and null safety. Follow the instructions carefully and implement the code in a simple console-based Kotlin project.

Start by creating an interface named Printable. This interface should have one function printDetails() with no implementation. Then create a class named Book that implements the Printable interface. The Book class should have the following properties: title (String), author (String), and price (Double). Use the override keyword to implement the printDetails() method, which should print the title, author, and price of the book.

Use visibility modifiers to control access to class members. For example, make the price property private, and create a public function called getPriceWithCurrency() that returns the price as a formatted string like "Rs. 500.0".

Next, add an extension function for the String class named firstWord() that returns only the first word of any string. Use this function in your program to print the first word of a book title.

Also, add an extension property to the Book class called discountedPrice, which returns 90% of the price (i.e., with a 10% discount). Use this property in the printDetails() method to show both original and discounted prices.

Finally, apply null safety. Create a nullable variable of type Book? and use the safe call operator (?.) to safely call the printDetails() function. Also, use the Elvis operator (?:) to show a default message like "Book not found" if the variable is null.

You only need to create one book object for this assignment. The purpose is to practice interfaces, visibility control, extensions, and null handling in Kotlin, all within a simple console-based program.

Best of luck*/


interface Printable {
    fun printDetails()
}

class Book : Printable {

    var bookTitle: String = ""
    var bookAuthor: String = ""
    private var bookPrice: Double? = null


    fun setBookPrice(price: Double) {
        if (price > 0) {
            bookPrice = price
        } else {
            println("!! aInvalid Book Price !!")
        }
    }

    fun getBookPriceWithCurrency(): String {
        return "The book price is RS $bookPrice "
    }


    fun getPrice(): Double? = bookPrice


    override fun printDetails() {

        println("Book Title : $bookTitle")
        println("Book Author : $bookAuthor")
        val price = getBookPriceWithCurrency()
        println(price)

        println((getDiscountedPrice))
    }


}

fun main() {


    val book: Book? = Book()

    book?.bookTitle = "The Psychology Of Money"

    book?.bookAuthor = "Nepolian Hill"

    book?.setBookPrice(1000.00)

    fun String.firstWord(): String {

        return this.split(" ")[0]
    }

    println("The book details are : ")
    println("Book Title : ${book?.bookTitle}")
    println("Book Author : ${book?.bookAuthor}")
    println(book?.getBookPriceWithCurrency())


    println("The first letter of book Title : ${book?.bookTitle?.firstWord()}")
    println("The first letter of Author name : ${book?.bookAuthor?.firstWord()}")

    println(book?.printDetails() ?: "Book Not Found")

}

val Book.getDiscountedPrice: String
    get() = "The discounted price is RS ${(getPrice()?.div(100.00))?.times(90.00)}"
    

