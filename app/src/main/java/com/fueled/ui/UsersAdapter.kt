package com.fueled.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fueled.R

class UsersAdapter() : RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    private val mDataList = arrayListOf<User>()

    fun setData(list: List<User>) {
        mDataList.clear()
        mDataList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_view_user, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = mDataList.get(position)
        holder.tvUserName.setText(user.name)
        holder.tvUserId.setText("${user.id}")
        holder.tvUserScore.setText("${user.score}")
    }

    inner class ViewHolder(root: View) : RecyclerView.ViewHolder(root) {
        val tvUserName: TextView = root.findViewById(R.id.tvUserName)
        val tvUserId: TextView = root.findViewById(R.id.tvUserId)
        val tvUserScore: TextView = root.findViewById(R.id.tvUserScore)
    }

    override fun getItemCount(): Int {
        return mDataList.size
    }
}