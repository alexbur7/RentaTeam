package com.alexbur.rentateam.data.repositories

import com.alexbur.rentateam.domain.entity.UserEntity
import com.alexbur.rentateam.domain.repositories.UsersListRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class UsersListRepositoryImp @Inject constructor(): UsersListRepository {
    override fun getUsers(): Single<List<UserEntity>> {
        TODO("Not yet implemented")
    }
}