package com.example.humblebot.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.humblebot.model.ChatMessage
import com.example.humblebot.repository.ChatRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ChatViewModel(private val repository: ChatRepository) : ViewModel() {
    private val _messages = MutableStateFlow<List<ChatMessage>>(emptyList())
    val messages: StateFlow<List<ChatMessage>> = _messages.asStateFlow()
    
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()
    
    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()
    
    fun sendMessage(text: String) {
        if (text.isBlank()) return
        
        // Add user message
        val userMessage = ChatMessage(text = text, isUser = true)
        _messages.value = _messages.value + userMessage
        
        // Clear previous error
        _error.value = null
        _isLoading.value = true
        
        viewModelScope.launch {
            repository.sendMessage(text)
                .onSuccess { reply ->
                    val botMessage = ChatMessage(text = reply, isUser = false)
                    _messages.value = _messages.value + botMessage
                }
                .onFailure { exception ->
                    _error.value = exception.message ?: "Unknown error occurred"
                }
            
            _isLoading.value = false
        }
    }
    
    fun clearError() {
        _error.value = null
    }
}