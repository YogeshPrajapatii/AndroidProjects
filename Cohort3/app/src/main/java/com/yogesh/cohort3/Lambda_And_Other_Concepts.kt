package com.yogesh.cohort3

// Lambda fun aise fun hote h jinka name nhi hota h or kisi temporaty use k liye use hote h mostly

/*val lambdaFun = { it: Int -> it * it }

val lambdaFunWithDoubleParameters = {a: Int,b: Int -> a+b}*/


// Higher Order Functions -> ye function ek function ko bhi parameter k roop me use kar sakte h 
// ya ek function ko return kar sakte h.

/*
fun higherOrderFunction(a: Int, b: Int, fn: (a: Int, b: Int) -> Int): Int {
    return fn(a, b)
}

val add = { a: Int, b: Int -> a + b }

val sub = { a: Int, b: Int -> a - b }
*/

/*val salary = {yoe: Int, rating:Int -> yoe * rating  }
fun higherOrderFun2(yoe:Int, rating: Int, growth:(yoe: Int, rating: Int)-> Int): Int{
    return growth(yoe,rating)
}


val area = {length: Int, breadth: Int -> length*breadth}*/


//Q1. Ek lambda banao jo kisi number ka square return kare.

val square = { num: Int -> num * num }

// Q2. Ek lambda banao jo do strings ko jod kar return kare.
val concetinate = { str1: String, str2: String -> str1 + str2 }

// Q3. Ek higher-order function banao jo 2 numbers aur ek lambda lega, aur return karega result.

val sum = { val1: Int, val2: Int -> val1 + val2 }
val sub = { val1: Int, val2: Int -> val1 - val2 }
val multiplication = { val1: Int, val2: Int -> val1 * val2 }
val division = { val1: Int, val2: Int -> val1 / val2 }

fun higherOrder3(val1: Int, val2: Int, fn: (Int, Int) -> Int): Int {
    return fn(val1, val2)
}

// Q4. Ek list lo aur usme se sirf even numbers filter karo using lambda.

val list = listOf(1,
    2,
    3,
    4,
    5,
    6,
    7,
    8,
    9,
    10,
    54,
    5,
    4521,
    421,
    480,
    4,
    5,
    0,
    4,
    0,
    1,
    4,
    8,
    12,
    4821,
    21,
    15,
    215,
    12,
    8,
    512,
    4,
    501)

val even = list.filter {it%2==0 }


fun main() {


    /*println(lambdaFun(5))
    println(lambdaFunWithDoubleParameters(557,43))*/

    /* val result = higherOrderFunction(1, 3, add)
     println(result)
 
     val sub = higherOrderFunction(5, 2, sub)
     println(sub)*/

    /*  val employee = higherOrderFun2(1,10,salary)
      println(employee)
  
      val lambdaUse = higherOrderFun2(1,10,area)
      println(lambdaUse)
      
      println(area(1000,8000))*/

    println(square(25))

    println(concetinate("Yogesh", " Verma"))

    println(higherOrder3(48755, 4459, multiplication))
    println(higherOrder3(1785, 4589, sum))
    println(higherOrder3(548755, 5459, sub))
    println(higherOrder3(2585, 89, division))
    
    println(even)

}







