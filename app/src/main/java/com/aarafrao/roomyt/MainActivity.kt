package com.aarafrao.roomyt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.aarafrao.roomyt.DB.User
import com.aarafrao.roomyt.VM.UserViewModel
import com.aarafrao.roomyt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)


        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]

        userViewModel.addUser(User(1, "Aaraf", "Email.com"))
        userViewModel.allUsers.observe(this, Observer {
            viewBinding.txtHello.text = it[it.size-1].email
        })

    }
}