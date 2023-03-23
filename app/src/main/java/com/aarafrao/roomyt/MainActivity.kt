package com.aarafrao.roomyt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.aarafrao.roomyt.DB.User
import com.aarafrao.roomyt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding
    private lateinit var vm: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        vm = ViewModelProvider(this)[VM::class.java]

        vm.addUser(User(0, "COdebot", "Email.com"))

        vm.allUsers.observe(this, Observer {
            viewBinding.txtHello.text = it[0].name
        })


    }
}