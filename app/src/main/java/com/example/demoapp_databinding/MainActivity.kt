package com.example.demoapp_databindi

import java.util.regex.Pattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.demoapp_databinding.R
import com.example.demoapp_databinding.databinding.ActivityMainBinding
import com.example.demoapp_databinding.model.LoginModelView
import com.example.demoapp_databinding.model.LoginModelViewFactory
import com.example.demoapp_databinding.model.Logins

class MainActivity : AppCompatActivity() {
    lateinit var databinding: ActivityMainBinding
    lateinit var viewmodels: LoginModelView
    lateinit var modelViewFactory: LoginModelViewFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        modelViewFactory = LoginModelViewFactory("", "", "Email", "Password")
        viewmodels = ViewModelProvider(this, modelViewFactory).get(LoginModelView::class.java)
        databinding.lifecycleOwner=this

        databinding?.login = viewmodels


    }

}