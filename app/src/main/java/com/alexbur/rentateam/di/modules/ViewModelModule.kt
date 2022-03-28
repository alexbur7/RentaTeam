package com.alexbur.rentateam.di.modules

import androidx.lifecycle.ViewModel
import com.alexbur.rentateam.di.ViewModelKey
import com.alexbur.rentateam.presentation.userslist.UsersListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @[IntoMap ViewModelKey(UsersListViewModel::class)]
    fun bindFindWeatherViewModel(findWeatherViewModel: UsersListViewModel): ViewModel
}