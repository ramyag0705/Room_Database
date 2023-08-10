package com.example.roomdatabase

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.data.User
import com.example.roomdatabase.databinding.CustomRowBinding

class UserListAdapter(var userList: List<User>, val viewModel: ListFragment) : RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    // Declare an interface for the click listener
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    // Declare a variable to hold the click listener
    private var listener: OnItemClickListener? = null

    // Method to set the click listener from the fragment/activity
    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CustomRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

//    fun updateData(newList: LiveData<List<User>>) {
//        userList = newList
//        notifyDataSetChanged()
//    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = userList[position]

        holder.binding.idTxt.text = user.id.toString()
        holder.binding.firstNameTxt.text = user.firstName
        //holder.binding.middleNameTxt.text = user.middleName
        holder.binding.lastNameTxt.text = user.lastName
        holder.binding.ageTxt.text = user.age.toString()

        // Set the click listener for the view holder
        holder.itemView.setOnClickListener {
            listener?.onItemClick(position)
        }
    }
//    fun setData(user: List<User>){
//        this.userList = user
//        notifyDataSetChanged()
//    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(val binding: CustomRowBinding) : RecyclerView.ViewHolder(binding.root)
}






