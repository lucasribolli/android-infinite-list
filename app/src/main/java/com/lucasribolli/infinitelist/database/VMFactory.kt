package com.lucasribolli.infinitelist.database

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lucasribolli.infinitelist.MainViewModel

class VMFactory(private val context: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java)
                -> MainViewModel(context) as T
            else -> throw IllegalArgumentException("$modelClass not found.")
        }
    }
}
