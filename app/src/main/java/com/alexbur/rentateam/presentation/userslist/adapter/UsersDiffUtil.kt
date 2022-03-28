package com.alexbur.rentateam.presentation.userslist.adapter

import androidx.recyclerview.widget.DiffUtil
import com.alexbur.rentateam.domain.entity.UserEntity

class UsersDiffUtil : DiffUtil.ItemCallback<UserEntity>() {

    override fun areItemsTheSame(oldItem: UserEntity, newItem: UserEntity): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: UserEntity, newItem: UserEntity): Boolean {
        return oldItem.firstName == newItem.firstName && oldItem.lastName == newItem.lastName
    }
}