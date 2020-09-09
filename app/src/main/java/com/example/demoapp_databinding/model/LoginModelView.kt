package com.example.demoapp_databinding.model

import android.content.Context
import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.regex.Pattern

class LoginModelView(email: String,pws: String,error_email:String,error_pws: String) : ViewModel() {

    var email = MutableLiveData<String>()
    var pws=MutableLiveData<String>()
    var error_email = MutableLiveData<String>()
    var error_pws = MutableLiveData<String>()

    init {
        this.pws.value=pws
        this.email.value=email
        this.error_email.value=error_email
        this.error_pws.value=error_pws
    }




     fun checkValidation() {

        if (!isEmailValid()) {
            error_email.value="Email Address is not valid"
            email.value=""
        } else {
            error_email.value="Email"
        }
        if (!isPasswordValid()) {
            error_pws.value="Password is not valid"
            pws.value=""

        } else {
            error_pws.value="Password"
        }

    }

    fun isEmailValid(): Boolean {
        var email=email.value
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email.toString()).matches()
    }

    fun isPasswordValid(): Boolean {
        var valid = true
        var pws=pws.value
        if (pws.toString().length < 8) {
            valid = true
        }
        // Password should contain at least one number
        var exp = ".*[0-9].*"
        var pattern = Pattern.compile(exp, Pattern.CASE_INSENSITIVE)
        var matcher = pattern.matcher(pws.toString())
        if (!matcher.matches()) {
            valid = false
        }

        // Password should contain at least one capital letter
        exp = ".*[A-Z].*"
        pattern = Pattern.compile(exp)
        matcher = pattern.matcher(pws.toString())
        if (!matcher.matches()) {
            valid = false
        }

        // Password should contain at least one small letter
        exp = ".*[a-z].*"
        pattern = Pattern.compile(exp)
        matcher = pattern.matcher(pws.toString())
        if (!matcher.matches()) {
            valid = false
        }

        // Password should contain at least one special character
        // Allowed special characters : "~!@#$%^&*()-_=+|/,."';:{}[]<>?"
        exp = ".*[~!@#\$%\\^&*()\\-_=+\\|\\[{\\]};:'\",<.>/?].*"
        pattern = Pattern.compile(exp)
        matcher = pattern.matcher(pws.toString())
        if (!matcher.matches()) {
            valid = false
        }


        return valid
    }


}