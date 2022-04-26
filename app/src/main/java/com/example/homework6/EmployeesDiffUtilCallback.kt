package com.example.homework6

import androidx.recyclerview.widget.DiffUtil

class EmployeesDiffUtilCallback(private val oldList: List<Employee>, private val newList: List<Employee>) :
    DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldEmployee: Employee = oldList[oldItemPosition]
        val newEmployee: Employee = newList[newItemPosition]
        return oldEmployee.id == newEmployee.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldEmployee: Employee = oldList[oldItemPosition]
        val newEmployee: Employee = newList[newItemPosition]
        return (oldEmployee.fullName == newEmployee.fullName
                && oldEmployee.photoUrl == newEmployee.photoUrl
                && oldEmployee.isLiked == newEmployee.isLiked)
    }
}