package com.alexbur.rentateam.presentation.userslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alexbur.rentateam.domain.entity.UserEntity
import com.alexbur.rentateam.domain.repositories.UsersListRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class UsersListViewModel @Inject constructor(
    usersListRepository: UsersListRepository
) : ViewModel() {

    val userListData: LiveData<List<UserEntity>>
        get() = _userListData

    private val compositeDisposable = CompositeDisposable()
    private val _userListData = MutableLiveData<List<UserEntity>>()

    init {
        usersListRepository.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    _userListData.value = it
                },
                {

                }
            ).also { compositeDisposable.add(it) }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}