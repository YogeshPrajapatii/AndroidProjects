package com.yogesh.cohort3

class Student : Person() {

    var rollNumber: Int = 0
    var grade: String = ""


    fun setStudentInfo(number: Int, grd: String) {
        this.rollNumber = number
        this.grade = grd
    }

    override fun getInfo() {
        println("Student's name is : $name")
        println("Student's age : $age")
        println("Student's roll number : $rollNumber")
        println("Student's grade is : $grade")
    }
}