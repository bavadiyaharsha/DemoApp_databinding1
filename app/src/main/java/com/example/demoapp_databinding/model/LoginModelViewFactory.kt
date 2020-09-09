package com.example.demoapp_databinding.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class LoginModelViewFactory(private val email:String,private val pws:String,val error_email:String,val error_pws:String): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(LoginModelView::class.java))
        {
            return LoginModelView(email,pws,error_email,error_pws) as T
        }
        throw IllegalArgumentException("Unknown model view ")
    }
}