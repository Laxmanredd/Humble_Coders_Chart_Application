package com.example.humblebot.repository

interface ChatRepository {
    suspend fun sendMessage(message: String): Result<String>
}