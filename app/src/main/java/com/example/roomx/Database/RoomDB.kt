package com.example.roomx.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [GithubRepo::class],version = 1, exportSchema = false)
public abstract class RoomDB(): RoomDatabase(){
    abstract fun repoDao():GithubDao

    companion object {
        private var INSTANCE: RoomDB? = null

        //acá estamos verificando si existe la db o si no se crea
        fun getInstance(AppContext: Context):RoomDB{
            val tempInstance = INSTANCE
            if (tempInstance != null) return tempInstance
            synchronized(this){
                val instance = Room.
                    databaseBuilder(AppContext,RoomDB::class.java,"RepoDB")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}