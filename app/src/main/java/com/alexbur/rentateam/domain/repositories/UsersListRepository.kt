package com.alexbur.rentateam.domain.repositories

import com.alexbur.rentateam.domain.entity.UserEntity
import io.reactivex.rxjava3.core.Observable

interface UsersListRepository {

    fun getUsers(): Observable<List<UserEntity>>
}