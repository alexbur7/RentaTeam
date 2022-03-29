package com.alexbur.rentateam.data.db.source

import com.alexbur.rentateam.data.db.dao.UserDao
import com.alexbur.rentateam.data.db.entity.UserDb
import com.alexbur.rentateam.data.mappers.UserDbToEntityMapper
import com.alexbur.rentateam.domain.entity.UserEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

interface UserSource {

    fun getUsers(): Observable<List<UserEntity>>

    fun insertUsers(users: List<UserDb>)
}

class UserSourceImp @Inject constructor(
    private val userDao: UserDao,
    private val userMapper: UserDbToEntityMapper
) : UserSource {

    override fun getUsers(): Observable<List<UserEntity>> {
        return userDao.getUsers().flatMapObservable {
            val data = if (it.isNullOrEmpty()) emptyList()
            else it
            Observable.fromCallable { data }
        }.map { data ->
            data.map(userMapper)
        }
    }

    override fun insertUsers(users: List<UserDb>) {
        return userDao.insertUsers(users)
    }

}