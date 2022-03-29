package com.alexbur.rentateam.domain.repositories

import androidx.lifecycle.MutableLiveData
import com.alexbur.rentateam.domain.entity.UserEntity
import io.reactivex.rxjava3.core.Observable

interface UsersListRepository {
    val errorMessageIdData: MutableLiveData<Int>

    fun getUsers(): Observable<List<UserEntity>>
}