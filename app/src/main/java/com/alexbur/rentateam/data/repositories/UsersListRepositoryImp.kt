package com.alexbur.rentateam.data.repositories

import androidx.lifecycle.MutableLiveData
import com.alexbur.rentateam.data.db.source.UserSource
import com.alexbur.rentateam.data.mappers.UserApiToEntityMapper
import com.alexbur.rentateam.data.mappers.UserEntityToDbMapper
import com.alexbur.rentateam.data.services.AppService
import com.alexbur.rentateam.domain.entity.UserEntity
import com.alexbur.rentateam.domain.repositories.UsersListRepository
import com.alexbur.rentateam.presentation.utils.ErrorHandler
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class UsersListRepositoryImp @Inject constructor(
    private val userSource: UserSource,
    private val appService: AppService,
    private val userMapper: UserApiToEntityMapper,
    private val userDbMapper: UserEntityToDbMapper,
    private val errorHandler: ErrorHandler
) : UsersListRepository {

    override val errorMessageIdData: MutableLiveData<Int> = MutableLiveData()

    override fun getUsers(): Observable<List<UserEntity>> {
        return Observable.concat(
            userSource.getUsers(),
            appService.getUsers().map { user ->
                user.data.map(userMapper)
            }.doOnSuccess { users ->
                userSource.insertUsers(users.map(userDbMapper))
            }.toObservable()
        ).onErrorResumeNext {
            errorMessageIdData.postValue(errorHandler.getErrorStringIdByThrowable(it))
            userSource.getUsers()
        }
    }
}