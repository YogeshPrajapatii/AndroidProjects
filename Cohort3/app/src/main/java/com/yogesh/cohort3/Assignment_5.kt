package com.yogesh.cohort3

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/*Dear Students,

Please complete the following advanced Kotlin assignment to deepen your understanding of collections, functional programming, generics, and coroutines. The program must be written as a console application and demonstrate the use of each concept clearly.

Start by creating a Kotlin program that simulates a basic task management system. Each task should have a title, isCompleted (Boolean), and priority (Int). Use a mutable list of tasks to store at least 5 different task objects with varying priorities and completion statuses.

Apply functional programming concepts using Kotlin collection functions. Filter the list to show 
only completed tasks, sort the tasks by priority, and map them to a list of titles. Also, use 
forEach to print the details of each task.*/




data class TaskManagementSystem(val title: String, val isCompleted: Boolean, val priority: Int
) {

    fun displayInfo() {
        println("Task: $title | Task Completed: $isCompleted | Priority: $priority")
    }

}


/*Next, define a generic class named Box<T> which can store and return a value of any type. Add a method getInfo(): String that returns a string describing the stored type and value. Create at least two boxes, for example: one storing an Int, and another storing a String. Use type variance to create a function that accepts Box<out Number> and prints numeric-related data.
*/


class Box<T>(val data: T) {
    fun getInfo(): String {
        return "The value of object is :$data and the type of value is : ${
            data!!::class.simpleName
        }"
    }
}

fun boxOutNumbers(box: Box<out Number>) {
    println("Value is ${box.data}")
}


/*Then, move on to coroutines and concurrency. Simulate fetching task data from a remote server using a coroutine. Create a suspend function called fetchTasks() that delays for 2 seconds using delay(2000) and then returns a list of task titles. Use runBlocking in your main function to call this suspend function and print the results.

This assignment gives you the opportunity to practice Kotlin’s powerful standard library features, explore generics and variance for reusable type-safe code, and understand how to work with asynchronous programming using coroutines. Be sure to test your code in a simple console project.

Best of luck!*/


suspend fun fetchTasks(): List<String> {
    delay(2000)
    return listOf("Reading", "Watching", "Learning", "Coding", "Practicing", "Keep Practicing")
}


fun main(): Unit = runBlocking {


    val taskList = mutableListOf<TaskManagementSystem>()
    val task1 = TaskManagementSystem("Loading", false, 1)
    val task2 = TaskManagementSystem("Downloading", true, 2)
    val task3 = TaskManagementSystem("Saving", false, 3)
    val task4 = TaskManagementSystem("Opening", true, 4)
    val task5 = TaskManagementSystem("Printing", false, 5)

    taskList.add(task1)
    taskList.add(task2)
    taskList.add(task3)
    taskList.add(task4)
    taskList.add(task5)

    println("Display all tasks :")
    println(taskList)

    println("Display all completed tasks :")
    taskList.filter { it.isCompleted }.forEach { it.displayInfo() }

    println("Display all task priority")
    taskList.sortBy { it.priority }
    taskList.forEach { println(it) }

    println("Println all task titles")
    val titles = taskList.map { it.title }
    titles.forEach { println(it) }


    val intBox = Box(21)
    val stringBox = Box("Yogesh Verma")

    println(intBox.getInfo())
    println(stringBox.getInfo())

    boxOutNumbers(intBox)
    //boxOutNumbers(stringBox)


    val task = fetchTasks()
    println(task)
}