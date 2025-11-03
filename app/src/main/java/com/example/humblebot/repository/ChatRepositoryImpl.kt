package com.example.humblebot.repository

import com.example.humblebot.BuildConfig
import com.example.api.GeminiApi
import com.example.humblebot.model.Content
import com.example.humblebot.model.GeminiRequest
import com.example.humblebot.model.Part
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ChatRepositoryImpl : ChatRepository {

    private val geminiApi: GeminiApi

    init {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://generativelanguage.googleapis.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        geminiApi = retrofit.create(GeminiApi::class.java)
    }

    override suspend fun sendMessage(message: String): Result<String> {
        return try {
            val request = GeminiRequest(
                contents = listOf(
                    Content(
                        parts = listOf(Part(text = message))
                    )
                )
            )

            val response = geminiApi.generateContent(BuildConfig.GEMINI_API_KEY, request)

            if (response.isSuccessful) {
                val body = response.body()
                val replyText = body?.candidates?.firstOrNull()?.content?.parts?.firstOrNull()?.text

                if (replyText != null) {
                    Result.success(replyText)
                } else {
                    Result.failure(Exception("Empty response from API"))
                }
            } else {
                Result.failure(Exception("API Error: ${response.code()} - ${response.message()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
