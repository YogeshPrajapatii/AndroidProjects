package com.yogesh.cohort3

import kotlin.random.Random

fun main() {
// Functions
    isEligible()
    checkGrade()
    checkNumber()
    printName()
    calSum()
    numSquare()
    whileLoop()
    reverseCounting()
    checkBiggestNumber()
    val result = isPrime()
    println(result)
    rollTheDice()
}
//1. Check if a person is eligible for a senior citizen discount (age 60+).

fun isEligible() {
    println("Please tell your age: ")
    val age = readLine()?.toInt() ?: 0

    if (age > 60) println("Congrats you can grab the discount offer.") else println("Sorry your age is bellow the criteria.")
}

// 2. Determine if a grade is pass (60+%) or fail.
fun checkGrade() {

    println("Please tell your percentage.")
    val percentage = readLine()?.toInt() ?: 0
    if (percentage > 60) println("You are pass as your percentage is $percentage") else println("You are fail your percentage is $percentage which is below 60.")
}

//3. Compare two numbers and print which is bigger.

fun checkNumber() {
    println("Enter first number :")
    val num1 = readLine()?.toInt() ?: 0

    println("Enter second number :")
    val num2 = readLine()?.toInt() ?: 0

    if (num1 > num2) {
        println("First number is greater.")
    } else if (num1 < num2) {
        println("Second number is greater.")
    } else {
        println("Both numbers are equal.")
    }
}

//For Loop

//1. Print your name 5 times.

fun printName() {
    println("Let's print my name multiple times.")
    val name: String = "Yogesh Verma"
    for (i in 1..5) {
        println(name)
    }
}
//2. Calculate the sum of numbers from 1 to 10.

fun calSum() {
    var sum = 0


    for (num in 1..10) {
        sum += num
    }
    println("The total is : $sum")
}
//3. Print the squares of numbers from 1 to 5 (1, 4, 9, 16, 25).

fun numSquare() {
    println("The square of numbers : ")
    for (number in 1..5) {
        println("The square of number is : ${number * number}")
    }
}

//While Loop
//
//1. Ask user for a password. Keep asking until they enter the correct password.

fun whileLoop() {

    println("Enter your password.")


    val password = "Yogesh123"
    var pwd = ""
    println("Please enter correct password.")
    pwd = readLine()?.toString() ?: ""
    while (pwd != password) {
        println("You entered incorrect password, please try again.")
        println("Please enter correct password.")
        pwd = readLine()?.toString() ?: ""
    }
    println("You entered correct password.")
}

//2. Count down from 5 to 1.


fun reverseCounting() {
    println("Counting in reverse.")
    var point = 5
    while (point >= 1) {
        println(point)
        point -= 1
    }
}

//3. Roll a virtual dice (1-6) until user wants to stop.

fun rollTheDice() {
    var choice: String = "y"
    while (choice.lowercase() == "y") {

        val dice = Random.nextInt(1, 7)
        println("Dice number is : $dice")

        println("Do you want to play again : (y/n)")
        choice = readLine() ?: "n"
    }
    println("Thanks")

}


//Mixing If/Else and Loops
//
//1. Ask user for 5 numbers. Print the biggest number.

fun checkBiggestNumber() {
    println("Let's check which number is biggest : ")
    println("Enter first number :")
    val num1 = readLine()?.toInt() ?: 0

    println("Enter second number :")
    val num2 = readLine()?.toInt() ?: 0

    println("Enter third number :")
    val num3 = readLine()?.toInt() ?: 0

    println("Enter forth number :")
    val num4 = readLine()?.toInt() ?: 0

    println("Enter fifth number :")
    val num5 = readLine()?.toInt() ?: 0

    if (num1 > num2 && num1 > num3 && num1 > num4 && num1 > num5) {
        println("First number is the biggest number.")
    } else if (num2 > num1 && num2 > num3 && num2 > num4 && num2 > num5) {
        println("Second number is the biggest number.")
    } else if (num3 > num1 && num3 > num2 && num3 > num4 && num3 > num5) {
        println("Third number is the biggest number.")
    } else if (num4 > num1 && num4 > num2 && num4 > num3 && num4 > num5) {
        println("Fourth number is the biggest number.")
    } else {
        println("Fifth number is the biggest number.")
    }


}
//2. Check if a number is prime (divisible only by 1 and itself).

fun isPrime(): String {
    println("Let's check the number is prime or not ")
    println("Please enter the number : ")
    val number = readLine()?.toInt() ?: 0

    for (i in 2 until number) {
        if (number <= 1) {
            return "NOT A PRIME NUMBER"
        } else if (number % i == 0) {
            return "NOT A PRIME NUMBER"
        }
    }
    return "IT'S A PRIME NUMBER"
}