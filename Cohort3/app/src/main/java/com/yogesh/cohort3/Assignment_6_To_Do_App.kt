package com.yogesh.cohort3/*
package com.yogesh.recomposition.cohort_3_assignments*/
/*
package com.yogesh.recomposition.cohort_3_assignments

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


*//*

*/
/*📝 Assignment: Create a Simple To-Do Task App Using State in Jetpack Compose
Dear Students,

You’ve already learned how to use remember and mutableStateOf in Jetpack Compose to manage state and build simple apps like a counter. Now, it’s time to take your skills to the next level. In this assignment, your task is to build a simple To-Do Task App. This app will help users add tasks and mark them as done. You will use state to manage the task list, so when a new task is added or removed, the app updates automatically.

Your app should have a text field at the top where the user can type the task name. Next to it, there should be a button called "Add Task". When the user types something and clicks the button, that task should appear below in a list. Each task in the list should be shown in a row with the task name and a "Done" button. When the user presses "Done", the task should disappear from the list.

If no tasks are added yet, show a simple message like "No tasks yet!" This will help you understand how to work with empty lists and conditionally show UI. You must use remember and mutableStateListOf to keep track of tasks. Try to keep your design clean and easy to use. You can also add some colors or spacing using Modifier.padding() and Modifier.fillMaxWidth().

This small project will help you learn how real apps change based on user actions, and how to control that using state. Don’t worry if it’s not perfect — just try your best and learn from the experience. 💡

Good luck, and have fun building your first interactive app! 🚀*//*
*/
/*



@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ToDoApp() {

    data class Task(val name: String, val isDone: Boolean)

    var task by rememberSaveable { mutableStateOf("") }
    val taskList = remember { mutableStateListOf<Task>() }



    Scaffold() {


        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top) {


            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)) {
                Spacer(modifier = Modifier.width(10.dp))


                OutlinedTextField(value = task,
                    onValueChange = { task = it },
                    placeholder = { Text("Enter your task!") },
                    modifier = Modifier
                        .height(50.dp)
                        .width(250.dp))

                Spacer(modifier = Modifier.width(10.dp))

                Button(onClick = {
                    if (task.isNotBlank()) {
                        taskList.add(Task(task, false))
                        task = ""
                    }
                }, modifier = Modifier
                    .height(45.dp)
                    .width(80.dp)) {
                    Text("ADD")
                }

            }
            Spacer(modifier = Modifier.height(10.dp))


            if (taskList.isEmpty()) {
                Text("No tasks yet!")
            } else {
                Column {

                    taskList.forEachIndexed { index, taskItem ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp, horizontal = 16.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {

                            Checkbox(checked = taskItem.isDone, onCheckedChange = {
                                val updatedTask = taskItem.copy(isDone = it)
                                taskList[index] = updatedTask
                            })
                            Spacer(modifier = Modifier.width(8.dp))


                            Text(taskItem.name, style = if (taskItem.isDone) {
                                TextStyle(textDecoration = TextDecoration.LineThrough)
                            } else {
                                TextStyle.Default
                            },

                                maxLines = 3, modifier = Modifier
                                    .weight(1f)
                                    .padding(end = 8.dp)


                            )
                            Spacer(modifier = Modifier.width(8.dp))

                            Button(onClick = {

                                taskList.removeAt(index)

                            }, modifier = Modifier
                                .height(45.dp)
                                .width(100.dp)

                            ) { Text("Remove") }


                        }
                    }


                }


            }


        }


    }


}


@Composable
@Preview(showSystemUi = true)
fun Preview() {
    ToDoApp()
}*/