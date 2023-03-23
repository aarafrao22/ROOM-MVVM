package com.aarafrao.roomyt.DB

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [User::class], version = 1)

abstract class AppDB : RoomDatabase() {
    abstract fun userDao(): UserDAO
}