package com.alexbur.rentateam.di

import android.content.Context
import com.alexbur.rentateam.di.modules.BindsModule
import com.alexbur.rentateam.di.modules.DatabaseModule
import com.alexbur.rentateam.di.modules.NetworkModule
import com.alexbur.rentateam.presentation.userslist.UsersListFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    modules =
    [
        BindsModule::class,
        NetworkModule::class,
        DatabaseModule::class
    ]
)
@Singleton
interface AppComponent {

    fun inject(usersListFragment: UsersListFragment)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }
}