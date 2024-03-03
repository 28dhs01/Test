package com.example.test.remember

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CounterViewModel : ViewModel(){
    fun increment() {
        _count.value++
    }

    fun greet() {
        Log.d("ViewModel", "Hello World!")
    }

    fun greet2() {
        Log.d("ViewModel","greet2 called")
    }

    private val _count = MutableStateFlow(0)
    val count = _count.asStateFlow()
}