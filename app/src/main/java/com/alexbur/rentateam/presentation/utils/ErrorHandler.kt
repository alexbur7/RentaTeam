package com.alexbur.rentateam.presentation.utils

import com.alexbur.rentateam.R
import retrofit2.HttpException
import java.net.ConnectException
import java.net.UnknownHostException
import javax.inject.Inject

class ErrorHandler @Inject constructor() {

    fun getErrorStringIdByThrowable(throwable: Throwable): Int{
        return when (throwable) {
            is HttpException -> {
                if (throwable.code() == 404){
                    R.string.unknown_city
                }
                else {
                    R.string.server_error
                }
            }
            is ConnectException, is UnknownHostException -> {
                R.string.connection_error
            }
            else ->
                R.string.unknown_exception
        }
    }
}