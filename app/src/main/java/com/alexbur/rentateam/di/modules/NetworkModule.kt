package com.alexbur.rentateam.di.modules

import com.alexbur.rentateam.data.services.AppService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import javax.inject.Singleton

@Module
class NetworkModule {
    private val contentType = "application/json".toMediaType()

    @Provides
    fun provideJson(): Json {
        return Json {
            ignoreUnknownKeys = true
        }
    }

    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    fun provideConverterFactory(json: Json): Converter.Factory {
        return json.asConverterFactory(contentType)
    }

    @Provides
    fun providesLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    fun providesHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }


    @Provides
    @Singleton
    fun providesRetrofit(converterFactory: Converter.Factory, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .baseUrl(BASE_URL).build()
    }

    @Provides
    fun providesAppService(retrofit: Retrofit): AppService {
        return retrofit.create(AppService::class.java)
    }

    private companion object {
        const val BASE_URL = "https://reqres.in/api/"
    }
}