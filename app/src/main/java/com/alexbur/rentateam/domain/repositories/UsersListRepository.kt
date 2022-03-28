package com.alexbur.rentateam.domain.repositories

import com.alexbur.rentateam.domain.entity.UserEntity
import io.reactivex.rxjava3.core.Single

interface UsersListRepository {

    fun getUsers(): Single<List<UserEntity>>
}