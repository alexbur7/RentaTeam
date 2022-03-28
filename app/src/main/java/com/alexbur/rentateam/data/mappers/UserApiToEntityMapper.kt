package com.alexbur.rentateam.data.mappers

import com.alexbur.rentateam.data.services.api.UserApi
import com.alexbur.rentateam.domain.entity.UserEntity
import javax.inject.Inject

class UserApiToEntityMapper @Inject constructor() : (UserApi) -> UserEntity {
    override fun invoke(user: UserApi): UserEntity =
        UserEntity(
            id = user.id,
            email = user.email,
            firstName = user.firstName,
            lastName = user.lastName,
            avatarUrl = user.avatarUrl
        )
}