package com.yogesh.learningkotlin

open class Person {

    var name: String = ""
    var age: Int = 0

    fun setInfo(n: String, a: Int) {
        this.name = n
        this.age = a

    }

    open fun getInfo() {

        print("The name of the person is : $name")
        println()
    }
}