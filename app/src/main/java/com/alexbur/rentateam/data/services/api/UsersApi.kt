package com.alexbur.rentateam.data.services.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UsersApi(
    @SerialName("data")
    val data: List<UserApi>
)