package com.app.planner.data.datasource

import android.content.Context
import android.content.SharedPreferences

private const val USER_REGISTRATION_FILE_NAME = "user_registration"
private const val IS_USER_REGISTERED = "is_user_registered"

class UserRegistrationLocalDataSourceImpl(
    private val applicationContext: Context
): UserRegistrationLocalDataSource {

    val userRegistrationSharedPreferences : SharedPreferences =
        applicationContext.getSharedPreferences(USER_REGISTRATION_FILE_NAME,Context.MODE_PRIVATE)

    override fun getIsUserRegistered(): Boolean {
        return userRegistrationSharedPreferences.getBoolean(IS_USER_REGISTERED,false)
    }

    override fun saveUserRegistered(isUserRegistered: Boolean) {
        with(userRegistrationSharedPreferences.edit()){
            putBoolean(IS_USER_REGISTERED, isUserRegistered)
            apply()
        }
    }
}