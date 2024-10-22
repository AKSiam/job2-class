package com.example.job2_class.Repository

import androidx.lifecycle.LiveData
import com.example.job2_class.Model.Profile
import com.example.job2_class.dao.ProfileDao

class ProfileRepository (private val userProfileDao: ProfileDao) {
    fun getUserProfiles(): LiveData<List<Profile>> {
        return userProfileDao.getAllUserProfiles()
    }

    suspend fun insert(userProfile: Profile) {
        userProfileDao.insert(userProfile)
    }

    suspend fun update(userProfile: Profile) {
        userProfileDao.update(userProfile)
    }

    suspend fun delete(userProfile: Profile) {
        userProfileDao.delete(userProfile)
    }
}