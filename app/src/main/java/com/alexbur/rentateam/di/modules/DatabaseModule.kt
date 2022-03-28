package com.alexbur.rentateam.di.modules

import android.content.Context
import androidx.room.Room
import com.alexbur.rentateam.data.db.RentaTeamDB
import com.alexbur.rentateam.data.db.dao.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun getWeatherDatabase(context: Context): RentaTeamDB {
        return Room.databaseBuilder(context, RentaTeamDB::class.java, "rentaTeamDB")
            .build()
    }

    @Provides
    fun getWeatherDao(rentaDb: RentaTeamDB): UserDao {
        return rentaDb.getUserDao()
    }
}