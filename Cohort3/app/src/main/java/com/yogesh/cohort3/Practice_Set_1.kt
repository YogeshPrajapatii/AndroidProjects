package com.yogesh.cohort3

/*


2. 🔁 Functions and Lambdas
Q3: Write a function that returns the factorial of a number. Now convert it to a lambda expression.

Q4: Write a function that takes a list of numbers and a lambda. It should return a new list containing only the elements that satisfy the lambda condition (e.g., even numbers, >10 etc).




🏁 Bonus Challenge
Create a mini console app that:

Asks user to enter book details (title, author, price)

Stores it in a class Book

Uses interface to print details

Uses extension to get first word of title

Uses null safety for error handling

Shows discounted price using extension property

This is like a final revision of everything you’ve learned 💡*/


/*1. ✅ Basics + Control Flow
Q1: Take a number input from the user. Check:

If it's even or odd.

If it's a positive number or negative.

If it’s divisible by 3, 5, or both.*/

fun controlFlow() {
    print("Please enter a number : ")
    val num = readLine()?.toIntOrNull() ?: 0

    if (num % 2 == 0) println("Number $num is even") else println("Num $num is odd")

    if (num >= 0) println("Num $num is positive") else println("Num $num is negative")

    if (num % 3 == 0 && num % 5 == 0) println("Num $num is divisible with both 3 and 5") else println(
        "Not Divisible")

}

/*Q2: Print numbers from 1 to 100:

Skip every multiple of 7 using continue

Stop the loop if a number reaches 73 using break*/

fun loopQue() {
    var num = 1
    for (i in num..100) {
        if (i % 7 == 0) continue
        if (num == 73) break
        println(num)
        
        num += 1
    }
}

/*
Q6: Create a base class Shape with a method area(). Inherit:

Circle(radius)

Rectangle(length, breadth)
Override and implement area() in each class.
*/

open class Shape {
    open fun area(): Double {
        println("Area")
        return 0.0
    }
}

class Circle(val radius: Int) : Shape() {

    override fun area(): Double {
        return 3.14 * radius * radius
    }
}

class Rectangle(val length: Int, val breadth: Int) : Shape() {
    override fun area(): Double {
        return length.toDouble() * breadth.toDouble()
    }
}


/*Q5: Create a class Employee with properties name, id, salary. Make a method displayInfo(). Now inherit Manager and add teamSize. Override the method.*/

/*
open class  Employee(val name: String, val id: String, val salary: Long){
    
    open fun displayInfo(){
        println("Name : $name")
        println("ID : $id")
        println("Salary : $salary")
    }
}

class  Manager : Employee(){
    override fun displayInfo() {
        super.displayInfo()
    }
}

class TeamSize : Employee(){
    override fun displayInfo() {
        super.displayInfo()
    }
}*/

/*4. 🚪 Visibility Modifiers
Q7: Create a class BankAccount:

accountHolder → public

balance → private

Add deposit() and withdraw() methods.
Try accessing balance outside class — understand error.
*/


class BankAccount {
    var accontHolder: String = ""
    private var balance: Long = 0

    fun deposit(amount: Long) {
        if (amount > 0) {
            balance += amount
            println(balance)
        }
    }

    fun withDraw(amount: Long) {
        if (balance > 0 && amount <= balance) {
            balance -= amount

            println(balance)
        }
    }

}

/*5. 🧩 Interface + Extension + Null Safety
Q8: Create an interface Clickable with click(). Class Button implements it.

Q9: Add an extension function wordCount() to String that returns number of words in it. Try it on any sentence.

Q10: Create a nullable variable of a class type. Use:

Safe call (?.)

Elvis operator (?:)

Not-null assertion (!!)
Print behavior in all three.
*/

interface Clickable{
    fun click()
}

class Button : Clickable {
    override fun click() {
       println("Button Clicked ")
    }
}


fun String.wordCount(): Int{
    
    return this.trim().split("\\s+".toRegex()).size
}



fun main() {

    // controlFlow()
    // loopQue()

    /*    val circle = Circle(5)
        println(circle.area())
        
        val rectangle = Rectangle(5,10)
        println(rectangle.area())*/

//    val employee = Employee("Yogesh", "PASSPORT",120000)

    /*
    val customer = BankAccount()
    customer.withDraw(500)
    customer.accontHolder = "Yogesh"
    customer.deposit(100000)
    customer.withDraw(50000)*/
    
    val str: String = "Hello My Name Yogesh Verma And I Am Learning Android Development"
    
    println(str.wordCount())
    
    val button: Button  = Button()
    
    println(button.click())


}