package com.alexbur.rentateam.presentation.userslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alexbur.rentateam.domain.entity.UserEntity
import com.alexbur.rentateam.domain.repositories.UsersListRepository
import com.alexbur.rentateam.presentation.utils.ErrorHandler
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class UsersListViewModel @Inject constructor(
    usersListRepository: UsersListRepository,
    errorHandler: ErrorHandler
) : ViewModel() {

    val userListData: LiveData<List<UserEntity>>
        get() = _userListData
    val isLoadingData: LiveData<Boolean>
        get() = _isLoadingData
    val errorMessageIdData: LiveData<Int>
        get() = _errorMessageIdData


    private val compositeDisposable = CompositeDisposable()
    private val _userListData = MutableLiveData<List<UserEntity>>()
    private val _isLoadingData = MutableLiveData<Boolean>()
    private val _errorMessageIdData = MutableLiveData<Int>()

    init {
        usersListRepository.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                _isLoadingData.value = true
            }.doAfterTerminate {
                _isLoadingData.value = false
            }
            .subscribe(
                {
                    _userListData.value = it
                },
                {
                    _errorMessageIdData.value = errorHandler.getErrorStringIdByThrowable(it)
                }
            ).also { compositeDisposable.add(it) }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}