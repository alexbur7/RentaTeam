package com.alexbur.rentateam.domain.entity

data class UserEntity(
    val id: Long,
    val email: String? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val avatarUrl: String? = null
)
