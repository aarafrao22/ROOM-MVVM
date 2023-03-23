package com.aarafrao.roomyt

import android.content.Context
import androidx.room.Room
import com.aarafrao.roomyt.DB.AppDB

object Database {
    private var instance: AppDB? = null

    fun getInstance(context: Context): AppDB {
        return instance ?: synchronized(this) {
            instance ?: Room.databaseBuilder(
                context.applicationContext,
                AppDB::class.java,
                "app_database"
            ).build().also {
                instance = it
            }
        }
    }
}
