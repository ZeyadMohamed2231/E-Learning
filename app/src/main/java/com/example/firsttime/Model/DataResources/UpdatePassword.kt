package com.example.firsttime.Model.DataResources

data class UpdatePassword(
    val email:String,
    val password: String,
    val newPassword: String
)
