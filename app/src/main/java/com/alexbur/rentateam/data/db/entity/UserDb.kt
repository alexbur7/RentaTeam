package com.alexbur.rentateam.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserDb(
    @PrimaryKey
    val id: Long,
)
