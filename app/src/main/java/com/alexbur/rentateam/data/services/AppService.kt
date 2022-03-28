package com.alexbur.rentateam.data.services

import com.alexbur.rentateam.data.services.api.UsersApi
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface AppService {

    @GET("users")
    fun getUsers(): Single<UsersApi>
}