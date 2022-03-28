package com.alexbur.rentateam.data.mappers

import com.alexbur.rentateam.data.db.entity.UserDb
import com.alexbur.rentateam.data.services.api.UserApi
import javax.inject.Inject

class UserApiToDbMapper @Inject constructor() : (UserApi) -> UserDb {
    override fun invoke(user: UserApi): UserDb =
        UserDb(
            id = user.id,
            email = user.email,
            firstName = user.firstName,
            lastName = user.lastName,
            avatarUrl = user.avatarUrl
        )
}