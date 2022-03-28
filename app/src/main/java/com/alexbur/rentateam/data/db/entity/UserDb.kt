package com.alexbur.rentateam.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserDb(
    @PrimaryKey
    val id: Long,
    val email: String? = null,
    @ColumnInfo(name = "first_name")
    val firstName: String? = null,
    @ColumnInfo(name = "last_name")
    val lastName: String? = null,
    @ColumnInfo(name = "avatar_url")
    val avatarUrl: String? = null
)
