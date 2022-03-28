package com.alexbur.rentateam.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.alexbur.rentateam.data.db.entity.UserDb
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe

@Dao
interface UserDao {

    @Query("SELECT * FROM UserDb")
    fun getUsers(): Maybe<List<UserDb>>

    @Insert(onConflict = REPLACE)
    fun insertUsers(users: List<UserDb>): Completable
}