package com.example.counter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class MainViewModel2(private val handle: SavedStateHandle): ViewModel() {
    private var count = 0

    val countLiveData = MutableLiveData<Int>()

    fun increaseCount() {
        count++
        countLiveData.value = count
    }
    fun decreaseCount() {
        count--
        countLiveData.value = count
    }
}