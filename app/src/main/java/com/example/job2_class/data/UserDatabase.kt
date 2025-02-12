package com.example.job2_class.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.job2_class.Model.Profile
import com.example.job2_class.dao.ProfileDao

@Database(entities = [Profile::class], version = 1)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userProfileDao(): ProfileDao

    companion object {
        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getDatabase(context: Context): UserDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_profile_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}