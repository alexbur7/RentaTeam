package com.alexbur.rentateam.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserEntity(
    val id: Long,
    val email: String? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val avatarUrl: String? = null
) : Parcelable
