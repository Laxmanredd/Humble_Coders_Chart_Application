package com.humblecoders.humblebot.repository

interface ChatRepository {
    suspend fun sendMessage(text: String): Result<String>
}
