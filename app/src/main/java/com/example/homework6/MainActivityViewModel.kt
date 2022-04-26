package com.example.homework6

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    val employees = MutableLiveData(Employee.getMockEmployees())

    fun addRandomEmployee() {
        employees.value = employees.value?.toMutableList()?.apply {
            add(Employee.getMockEmployees().random())
        }
    }

    fun likeEmployee(position: Int) {
        val currentState = employees.value?.get(position)?.isLiked
        employees.value?.get(position)?.isLiked = currentState != true
    }
}