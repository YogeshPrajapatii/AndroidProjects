package com.yogesh.cohort3

class Teacher : Person() {
    var subject: String = ""
    var salary: Double = 0.0

    fun setTeacherInfo(sub: String, sal: Double) {
        this.subject = sub
        this.salary = sal
    }

    override fun getInfo() {
        println("The teachers name is : $name")
        println("The teachers age is : $age")
        println("The teachers subject is : $subject")
        println("The teachers salary is : $salary")
    }

}