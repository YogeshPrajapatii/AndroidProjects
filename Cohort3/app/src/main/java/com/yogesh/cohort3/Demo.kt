package com.yogesh.cohort3

// Default Constructor
/*class Sample {
    var name: String = ""
    var rollNumber: Int = 0

    fun studentDetails() {
        println("Student name is $name and student roll number is $rollNumber")
    }
}*/

// Primary Constructor
/*class Demo(val name: String, val rollNumber: Int) {
    fun introduction() {
        println("Hi my name is name is : $name \n And my roll number is : $rollNumber")
    }
}*/

// Secondary Constructor

class Const {
    var name: String
    var city: String

    constructor(n: String, c: String) {
        this.name = n
        this.city = c

        if (n != c) println("My name is : $n and my city is : $c")
    }

}


fun main() {/*val age = 21
    println("My age is : $age years")

    var a  = 10
    val b = 5
    a += b
    println(a)

    var num = 145
    if(num%2==0) println("Number is even.") else println("Number is odd.")

    val age : Int = 20
    if (age>=18) println("You are eligible to vote.") else println("You are not eligible to vote.")

    val marks : Int = 95
    if (marks>=90) println("A+") else if(marks>=75) println("A") else if(marks>=60) println("B") else println("Fail")

    for(i in 1..10){
        println(i)
    }

    for(num in 1..20){
        if(num%2==0) println("Even number :  $num") else println("Odd number :  $num")
    }

    for (number in 1..7){
        if (number == 5) continue else println(number)
    }

    var value = 10
    while (value>=1){
        println(value)
        value--
    }



    for (i in 1..10) {
        println(i*7)
    }

        var sum = 0
        for (i in 1..10){
            sum += i
        }
        println(sum)*/

    /* // Ab vo questions attempt kar rha hu jo pahle nhi hue the solve.

     /*val a = 10
     a = 25  NOT POSSIBLE BECAUSE VAL IS USED TO DECLARE CONSTANT VALUES THAT CAN'T BE MODIFIED.

 // Q3 nhi aata
     val bmi = Bmi(58, 5.58)
     println(bmi)
 }
 // Q4

 fun Bmi(weight: Int, height: Double): Double {

     return weight / (height * height)
 }

 Q10. Use when to print day of the week (1 to 7)

 Q11. Modify when to handle invalid days (0 or 8)

 Q12. Use when to print season based on month number

     [C] Loops (Q13–Q20)
     Tu ne for loop, even/odd, while, table of 7, skip 5, sum try kiya.

     Unattempted:

     Q18. Print pattern using nested loop:

     Copy
     Edit
     1 2 3
     1 2 3
     1 2 3*/*/

    /*  val student1 = Sample()
      student1.name = "Yogesh Verma"
      student1.rollNumber = 151
      student1.studentDetails()*/

    /* val student2 = Demo("Yogesh Verma", 151)
     student2.introduction() */

    val student3 = Const("Yogesh Verma", "Bhiwani")

}