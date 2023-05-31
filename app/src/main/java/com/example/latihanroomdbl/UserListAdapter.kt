package com.example.latihanroomdbl

import android.annotation.SuppressLint
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.latihanroomdbl.data.User
import com.example.latihanroomdbl.databinding.CustomRowBinding

class UserListAdapter: RecyclerView.Adapter<UserListAdapter.MyViewHolder>() {
    private var userList = emptyList<User>()
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_row,parent,false))
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val currentItem = userList[position]
        holder.itemView.findViewById<TextView>(R.id.tvId).text = currentItem.id.toString()
        holder.itemView.findViewById<TextView>(R.id.tvFirstname).text = currentItem.firstName
        holder.itemView.findViewById<TextView>(R.id.tvLastname).text = currentItem.lastName
        holder.itemView.findViewById<TextView>(R.id.tvAge).text = currentItem.age.toString()

        if (position %2 == 0){
            holder.itemView.findViewById<LinearLayout>(R.id.rowLayout).setBackgroundColor(Color.YELLOW)
        }else{
            holder.itemView.findViewById<LinearLayout>(R.id.rowLayout).setBackgroundColor(R.color.coklat)
        }

        // aksi pada list to update data atau mengubah data
        holder.itemView.findViewById<LinearLayout>(R.id.rowLayout).setOnClickListener{
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setData(user: List<User>){
        this.userList = user
        notifyDataSetChanged()
    }
}