package com.example.myapplication

import android.app.Application
import androidx.room.Room

class MisUsuarios : Application(){

    companion object {
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database =  Room.databaseBuilder(this, AppDatabase::class.java, "tasks-db").build()
    }
}