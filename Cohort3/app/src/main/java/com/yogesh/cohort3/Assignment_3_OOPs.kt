package com.yogesh.cohort3

/*Dear Students,

Please complete the following OOP assignment in Kotlin as part of your learning. This task will help you understand the basics of classes, inheritance, and method overriding. Kindly read the instructions carefully and try to complete it using only the concepts we’ve covered so far.

Start by creating a class named Person that has two properties: name (of type String) and age (of type Int). In this class, write a method named displayInfo() that prints the name and age of the person. Now, create a class named Student that inherits from the Person class. This Student class should have additional properties: rollNumber (Int) and grade (String). Override the displayInfo() method in the Student class to include the student's roll number and grade in the output.

Next, create another class named Teacher that also inherits from the Person class. This Teacher class should include extra properties: subject (String) and salary (Double). Override the displayInfo() method in the Teacher class to show all relevant details, including subject and salary.

In the main function of your program, create one object of the Student class and one object of the Teacher class. Assign values to their properties and call their displayInfo() methods to print the information to the console. This will help you practice how to create objects, call methods, use inheritance, and override functions in Kotlin.

Best of luck!*/


fun main() {

    println("Person's Info!")
    val objPerson = Person()
    objPerson.setInfo("Yogesh", 25)
    objPerson.getInfo()

    println()
    println("Student's Info!")
    val objStudent = Student()
    objStudent.setInfo("Rahul", 18)
    objStudent.setStudentInfo(85, "A+")
    objStudent.getInfo()

    println()
    println("Teacher's Info!")
    val objTeacher = Teacher()
    objTeacher.setInfo("Gaurav", 25)
    objTeacher.setTeacherInfo("Android Development", 100000.00)
    objTeacher.getInfo()
}