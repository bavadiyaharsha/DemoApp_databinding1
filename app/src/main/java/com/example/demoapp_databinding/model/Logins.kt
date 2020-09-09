package com.example.demoapp_databinding.model

data class Logins(
    var email:String,
    var pws:String,
    var erroremail:String="Email",
    var errorpws: String ="Password"
)