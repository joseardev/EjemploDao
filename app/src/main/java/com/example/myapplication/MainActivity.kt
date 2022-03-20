package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import java.nio.file.attribute.UserPrincipalLookupService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//allowMainThreadQueries para permitir usarlo en la rama principal
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-user"
        ).allowMainThreadQueries().build()


        val userDao = db.userDao()



        val person2 = User(4,"John","alonso")
     /*   person2.firstName = ""
        person2.lastName = ""
        person2.uid = 1*/


        userDao.insertAll(person2)

        val users: List<User> = userDao.getAll()

        var user = userDao.loadAllByIds(1)

        if(user != null){
            user.size
        }

    }
}