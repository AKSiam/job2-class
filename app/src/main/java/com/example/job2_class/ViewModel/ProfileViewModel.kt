package com.example.job2_class.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.job2_class.Model.Profile
import com.example.job2_class.Repository.ProfileRepository
import com.example.job2_class.data.UserDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ProfileRepository
    init {
        val argentinaProfileDao = UserDatabase.getDatabase(application).userProfileDao()
        repository = ProfileRepository(argentinaProfileDao)
    }

    fun getUserProfiles(): LiveData<List<Profile>> {
        return repository.getUserProfiles()
    }

    fun insertUserProfile(profile: Profile) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(profile)
        }
    }

    fun updateUserProfile(profile: Profile) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.update(profile)
        }
    }

    fun deleteUserProfile(profile: Profile) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(profile)
        }
    }
}