package com.example.counter_mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel() {
    private var counter = 0
    private val counterLiveData = MutableLiveData<Int>()

    init {
        counterLiveData.value = counter
    }

    fun getCounter(): MutableLiveData<Int> {
        return counterLiveData
    }

    fun incrementCounter() {
        counter++
        counterLiveData.value = counter
    }

    fun decrementCounter() {
        counter--
        counterLiveData.value = counter
    }
}