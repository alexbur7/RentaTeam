package com.alexbur.rentateam.di.modules

import com.alexbur.rentateam.data.db.source.UserSource
import com.alexbur.rentateam.data.db.source.UserSourceImp
import com.alexbur.rentateam.data.repositories.UsersListRepositoryImp
import com.alexbur.rentateam.domain.repositories.UsersListRepository
import dagger.Binds
import dagger.Module

@Module
interface BindsModule {

    @Binds
    fun bindUserListRepository(usersListRepositoryImp: UsersListRepositoryImp): UsersListRepository

    @Binds
    fun bindUserSource(userSourceImp: UserSourceImp): UserSource
}