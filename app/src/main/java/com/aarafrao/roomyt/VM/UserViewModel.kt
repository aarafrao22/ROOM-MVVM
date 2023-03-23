package com.aarafrao.roomyt.VM

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.aarafrao.roomyt.DB.User
import com.aarafrao.roomyt.Database
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val userDao = Database.getInstance(application).userDao()
    val allUsers: LiveData<List<User>> = userDao.getAllUsers()

    fun addUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userDao.addUser(user)
        }
    }

    fun deleteUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userDao.deleteUser(user)
        }
    }

    fun updateUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userDao.updateUser(user)
        }
    }
}

