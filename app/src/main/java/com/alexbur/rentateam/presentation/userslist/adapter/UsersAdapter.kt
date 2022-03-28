package com.alexbur.rentateam.presentation.userslist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alexbur.rentateam.databinding.ItemUserBinding
import com.alexbur.rentateam.domain.entity.UserEntity

class UsersAdapter(
    private val onClick: (UserEntity) -> Unit
) : ListAdapter<UserEntity, UserHolder>(UsersDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewHolder = UserHolder(binding)
        viewHolder.itemView.setOnClickListener {
            if (viewHolder.adapterPosition != RecyclerView.NO_POSITION) {
                onClick(getItem(viewHolder.adapterPosition))
            }
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}