package com.alexbur.rentateam.data.repositories

import com.alexbur.rentateam.data.db.source.UserSource
import com.alexbur.rentateam.data.mappers.UserApiToEntityMapper
import com.alexbur.rentateam.data.mappers.UserEntityToDbMapper
import com.alexbur.rentateam.data.services.AppService
import com.alexbur.rentateam.domain.entity.UserEntity
import com.alexbur.rentateam.domain.repositories.UsersListRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class UsersListRepositoryImp @Inject constructor(
    private val userSource: UserSource,
    private val appService: AppService,
    private val userMapper: UserApiToEntityMapper,
    private val userDbMapper: UserEntityToDbMapper
) : UsersListRepository {
    override fun getUsers(): Observable<List<UserEntity>> {
        return Observable.concatArrayDelayError(
            userSource.getUsers(),
            appService.getUsers().map {
                it.data.map(userMapper)
            }.doOnSuccess {
                userSource.insertUsers(it.map(userDbMapper))
            }.toObservable()
        )
    }
}