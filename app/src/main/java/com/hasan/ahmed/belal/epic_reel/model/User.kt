package com.hasan.ahmed.belal.epic_reel.model

import com.google.gson.Gson

class User (var fullName: String, var email : String , var password : String , var currentUser : Boolean) {

    fun updateInfo (fullName: String, email: String) {
        this.fullName = fullName
        this.email = email
    }

    fun updatePassword (password: String) {
        this.password = password
    }

    fun toJSON() : String {
        return Gson().toJson(this)
    }

}

