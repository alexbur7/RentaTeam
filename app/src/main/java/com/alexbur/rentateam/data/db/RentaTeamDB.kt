package com.alexbur.rentateam.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alexbur.rentateam.data.db.dao.UserDao
import com.alexbur.rentateam.data.db.entity.UserDb

@Database(entities = [UserDb::class], version = 1, exportSchema = false)
abstract class RentaTeamDB : RoomDatabase() {

    abstract fun getUserDao(): UserDao
}