package com.aarafrao.roomyt

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.aarafrao.roomyt.DB.Database
import com.aarafrao.roomyt.DB.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VM(application: Application) : AndroidViewModel(application) {
    private val userDAO = Database.getInstance(application).userDao()

    val allUsers: LiveData<List<User>> = userDAO.getAllUsers()


    fun addUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userDAO.addUser(user)
        }
    }

    fun deleteUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userDAO.deleteUser(user)
        }
    }


}