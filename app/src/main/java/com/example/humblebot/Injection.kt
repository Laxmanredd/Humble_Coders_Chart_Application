package com.example.humblebot

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.humblebot.repository.ChatRepositoryImpl
import com.example.humblebot.viewmodel.ChatViewModel

object Injection {
    fun provideViewModelFactory(): ViewModelProvider.Factory {
        return object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(ChatViewModel::class.java)) {
                    val repository = ChatRepositoryImpl()
                    @Suppress("UNCHECKED_CAST")
                    return ChatViewModel(repository) as T
                }
                throw IllegalArgumentException("Unknown ViewModel class")
            }
        }
    }
}