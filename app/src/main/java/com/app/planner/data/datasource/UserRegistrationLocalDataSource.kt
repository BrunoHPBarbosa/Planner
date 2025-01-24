package com.app.planner.data.datasource

interface UserRegistrationLocalDataSource {

    fun getIsUserRegistered(): Boolean

    fun saveUserRegistered(isUserRegistered: Boolean)
}