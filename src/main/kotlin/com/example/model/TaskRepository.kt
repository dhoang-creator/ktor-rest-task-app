package com.example.model

import java.lang.IllegalStateException

/**
 *  The reason we added this folder is to ensure dynamic Routes rather than having call responses to each of the below cases:
 *      - Allowing us to add gateways; and
 *      - Add GET, POST, DELETE routes for extension purposes
 *
 *  The additional functionality by way of the functions, allows us to extend upon the 'mutableList'
 */
object TaskRepository {
    private val tasks = mutableListOf(
        Task("cleaning", "Clean the house", Priority.Low),
        Task("gardening", "Mow the Lawn", Priority.Medium),
        Task("shopping", "Buy the groceries", Priority.High),
        Task("painting", "Paint the fence", Priority.Medium)
    )

    fun allTasks(): List<Task> = tasks

    fun tasksByPriority(priority: Priority) = tasks.filter {
        it.priority == priority
    }

    fun tasksByName(name: String) = tasks.find {
        it.name.equals(name, ignoreCase = true)
    }

    fun addTask(task: Task) {
        if (tasksByName(task.name) != null) {
            throw IllegalStateException("Cannot duplicate task names!")
        }
        tasks.add(task)
    }

    fun removeTask(name: String): Boolean {
        return tasks.removeIf { it.name == name }
    }
}