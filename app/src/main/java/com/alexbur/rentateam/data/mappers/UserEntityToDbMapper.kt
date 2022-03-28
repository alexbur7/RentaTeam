package com.alexbur.rentateam.data.mappers

import com.alexbur.rentateam.data.db.entity.UserDb
import com.alexbur.rentateam.domain.entity.UserEntity
import javax.inject.Inject

class UserEntityToDbMapper @Inject constructor() : (UserEntity) -> UserDb {
    override fun invoke(user: UserEntity): UserDb =
        UserDb(
            id = user.id,
            email = user.email,
            firstName = user.firstName,
            lastName = user.lastName,
            avatarUrl = user.avatarUrl
        )
}