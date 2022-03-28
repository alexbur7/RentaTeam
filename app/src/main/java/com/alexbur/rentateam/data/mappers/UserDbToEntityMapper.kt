package com.alexbur.rentateam.data.mappers

import com.alexbur.rentateam.data.db.entity.UserDb
import com.alexbur.rentateam.domain.entity.UserEntity
import javax.inject.Inject

class UserDbToEntityMapper @Inject constructor() : (UserDb) -> UserEntity {
    override fun invoke(user: UserDb): UserEntity =
        UserEntity(
            id = user.id,
            email = user.email,
            firstName = user.firstName,
            lastName = user.lastName,
            avatarUrl = user.avatarUrl
        )
}