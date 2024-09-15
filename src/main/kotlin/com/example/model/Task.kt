package com.example.model

import kotlinx.serialization.Serializable

enum class Priority {
    Low, Medium, High, Vital
}

// some googling brought you to an older version wherein you could import Serializable
@Serializable
data class Task(
    val name: String,
    val description: String,
    val priority: Priority
)