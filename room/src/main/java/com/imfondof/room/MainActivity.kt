package com.imfondof.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.imfondof.room.data.AppDatabase
import com.imfondof.room.data.User
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        thread {
            val userDao = AppDatabase.getDatabase(this).userDao()
            val user1 = User("Tom", "Brady", 40)
            val user2 = User("Tom", "Hanks", 63)

            user1.id = userDao.insertUser(user1)
            user2.id = userDao.insertUser(user2)
            Log.d("shuoshuo", "shuo, user1.id: ${user1.id}, user2.id: ${user2.id}")

            for(user in userDao.loadAllUsers()) {
                Log.d("shuoshuo", "shuo, $user")
            }

            user1.age = 55
            userDao.updateUser(user1)

            userDao.deleteUserByLastName("Hanks")

            for(user in userDao.loadAllUsers()) {
                Log.d("shuoshuo", "shuo, $user")
            }
        }
    }
}