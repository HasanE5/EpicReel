package com.hasan.ahmed.belal.epic_reel.model

class user (var fullName: String, var email : String , var password : String) {
    fun setFullName(fullName: String) {
        this.fullName = fullName
    }

    fun getFullName(): String {
        return fullName
    }

    fun setEmail(email: String) {
        this.email = email
    }

    fun getEmail(): String {
        return email
    }

    fun setPassword(password: String) {
        this.password = password
    }

    fun getPassword(): String {
        return password
    }
}