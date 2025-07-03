package com.yogesh.cohort3

fun main() {

    greet("Yogesh Verma")

    val average = numberAverage(25, 2)
    println(average)

    checkOddEven()

    checkSmallestNumber()

    isDivisible()
    oddEvenWithLoop()
    listExample()
    funAndList()
    specificInput()
    checkCredentials()
    stringConcept()
    //checkName()
    countKotlinOccurence()
}

// Functions

//1. Create a function that takes a name as a parameter and prints a greeting like: Hello, [name]Welcome to Kotlin.

fun greet(name: String) {
    println("Hello $name welcome to kotlin.")
}


//2. Write a function that takes two numbers and returns their average.

fun numberAverage(num1: Int, num2: Int): Int {
    print("The average of  $num1 and $num2  is: ")
    return (num1 + num2) / 2
}

//3. Make a function that checks if a number is even or odd and returns a message.

fun checkOddEven() {
    print("Please enter the number : ")
    val number = readLine()?.toInt() ?: 0
    if (number % 2 == 0) println("The number $number is even") else println("The number $number is odd.")
}


// Lists

fun listExample() {
//1. Ask the user to enter 5 numbers and store them in a list. Then, print the list.
    val numberList = mutableListOf<Int>()
    print("Please enter the number : ")
    val num1 = readLine()?.toIntOrNull() ?: 0
    print("Please enter the number : ")
    val num2 = readLine()?.toIntOrNull() ?: 0
    print("Please enter the number : ")
    val num3 = readLine()?.toIntOrNull() ?: 0
    print("Please enter the number : ")
    val num4 = readLine()?.toIntOrNull() ?: 0
    print("Please enter the number : ")
    val num5 = readLine()?.toIntOrNull() ?: 0

    numberList.add(num1)
    numberList.add(num2)
    numberList.add(num3)
    numberList.add(num4)
    numberList.add(num5)

    println(numberList)

//2. From the list above, print only the even numbers using a loop.

    for (num in numberList) {
        if (num % 2 == 0) println("The num : $num is even")
    }


//3. Create a list of your 5 favorite fruits. Print them using a loop with the format: I like Apple, I like Banana, etc.

    val fruitList = listOf<String>("Apple", "Banana", "Avocado", "Grapes", "WaterMelon")

    for (fruit in fruitList) {
        println("I like $fruit")
    }
}


// Loops with Conditions

//1. Ask the user to enter 5 numbers one by one. After all entries, print the smallest number.

fun checkSmallestNumber() {
    println("Let's check which number is smallest : ")
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

    if (num1 < num2 && num1 < num3 && num1 < num4 && num1 < num5) {
        println("First number is the smallest number.")
    } else if (num2 < num1 && num2 < num3 && num2 < num4 && num2 < num5) {
        println("Second number is the smallest number.")
    } else if (num3 < num1 && num3 < num2 && num3 < num4 && num3 < num5) {
        println("Third number is the smallest number.")
    } else if (num4 < num1 && num4 < num2 && num4 < num3 && num4 < num5) {
        println("Fourth number is the smallest number.")
    } else {
        println("Fifth number is the smallest number.")
    }


}

//2. Count how many numbers from 1 to 50 are divisible by both 3 and 5.

fun isDivisible() {
    for (num in 1..50) {
        if (num % 5 == 0 && num % 3 == 0) println("The numbers which are divisible with both 5 and 3 are : $num")
    }
}

//3. Ask the user to enter a number. Use a loop to print whether each number from 1 to that number is even or odd.

fun oddEvenWithLoop() {
    println("Please enter the number : ")
    val number = readLine()?.toInt() ?: 0

    for (num in 1..number) {
        if (num % 2 == 0) println("The number :$num is even") else println("The number :$num is odd")
    }
}


// Function + Loop (Mixing Concepts)

//1. Make a function that takes a list of numbers and returns the total sum.
fun funAndList() {
    val numberList = mutableListOf<Int>()
    print("Please enter the number : ")
    val num1 = readLine()?.toIntOrNull() ?: 0
    print("Please enter the number : ")
    val num2 = readLine()?.toIntOrNull() ?: 0
    print("Please enter the number : ")
    val num3 = readLine()?.toIntOrNull() ?: 0
    print("Please enter the number : ")
    val num4 = readLine()?.toIntOrNull() ?: 0
    print("Please enter the number : ")
    val num5 = readLine()?.toIntOrNull() ?: 0

    numberList.add(num1)
    numberList.add(num2)
    numberList.add(num3)
    numberList.add(num4)
    numberList.add(num5)

    var sum = 0
    for (num in numberList) {
        sum += num
    }
    println("The total of the list numbers is : $sum")
}

//2. Ask the user to keep entering numbers until they enter 0. Then print the average of all the entered numbers.

fun specificInput() {

    val mutableList = mutableListOf<Int>()

    do {
        print("Please enter the correct number : ")
        var input = readLine()?.toIntOrNull()

        if (input != null && input != 0) {

            mutableList.add(input)
        }

    } while (input != 0)

    println(mutableList)

    var value = 0
    for (values in mutableList) {
        value += values
    }
    println("The average of the list numbers is : ${value / mutableList.size}")
}

//3. Make a login function that checks if the entered username and password are correct. Keep asking
//until the correct credentials are given.

fun checkCredentials() {
    val correctUserName = "Yogesh99"
    val correctPassword = "Yogesh@123456"

    var userName = ""
    var password = ""
    do {
        println("Please enter the username : ")
        var userName = readLine()
        println("Please enter the password : ")
        var password = readLine()

        if (userName != correctUserName && password != correctPassword) {
            println("You enter invalid login credentials! Please try again !")
        } else {
            println("Login Success !")
        }

    } while (userName != correctUserName && password != correctPassword)
}

// String Handling

//1. Ask the user to enter a sentence. Print how many characters and how many words it contains.

fun stringConcept() {
    print("Please enter a string : ")
    var myString = readLine()?.trim()
    if (!myString.isNullOrEmpty()) {
        print("The entered string is : $myString")
        print("The contains ${myString.length} characters ")

        val words = myString.split("\\s+".toRegex())
        println("The total words in the string is : ${words.size}")
    }
}


//2. Ask the user to enter a sentence. Print how many times the word "kotlin" appears (ignore
//capital/small letters).

fun countKotlinOccurence() {
    println("Please enter a sentence : ")
    val sentence = readLine()?.lowercase()?.trim()

    if (!sentence.isNullOrEmpty()) {
        val words = sentence.split("\\s+".toRegex())
        val count = words.count { it == "kotlin" }

        println("The word kotlin occures $count times.")
    } else {
        println("Wrong Input!")
    }
}
//3. Ask the user to enter a name. If the name starts with the letter A, print Welcome A-student!, else
//print Hello student!

fun checkName() {
    print("Please enter a name : ")
    var myName = readLine()
    print("The entered name is : $myName")

    if (myName?.startsWith('A') == true) {
        println("Welcome A $myName")
    } else {
        println("Hello $myName")
    }
}