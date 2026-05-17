package com.example.sehatsetu.models

data class ChatMessage(

    val sender: String = "",

    val message: String = "",

    val timestamp: Long =
        System.currentTimeMillis()
)