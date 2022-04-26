package com.example.homework6

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.with


class EmployeesAdapter(private val likeAction: (Int) -> Unit) :
    RecyclerView.Adapter<EmployeesAdapter.EmployeesViewHolder>() {

    private val employees = mutableListOf<Employee>()

    class EmployeesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photoImageView: ImageView = itemView.findViewById(R.id.photo)
        val isLikedButton: ImageView = itemView.findViewById(R.id.isLikedButton)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EmployeesAdapter.EmployeesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.employee_list_item, parent, false)
        return EmployeesViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmployeesAdapter.EmployeesViewHolder, position: Int) {
        val employee = employees[position]
        with(holder) {

            Glide.with(photoImageView.context)
                .load(employee.photoUrl)
                .centerCrop()
                .into(photoImageView)

            photoImageView.setOnClickListener {
                likeAction(position)
                if (employee.isLiked) isLikedButton.visibility = View.VISIBLE
                else isLikedButton.visibility = View.INVISIBLE
            }
        }
    }

    override fun getItemCount(): Int {
        return employees.size
    }

    fun reload(data: List<Employee>) {
        val diffUtilCallback = EmployeesDiffUtilCallback(employees, data)
        val employeesDiffResult = DiffUtil.calculateDiff(diffUtilCallback)
        employees.clear()
        employees.addAll(data)
        employeesDiffResult.dispatchUpdatesTo(this)
    }
}