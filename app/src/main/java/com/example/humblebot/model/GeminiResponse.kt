package com.example.humblebot.model

data class GeminiResponse(
    val candidates: List<Candidate>
)

data class Candidate(
    val content: Content
)