package com.app.planner.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.app.planner.data.datasource.UserRegistrationLocalDataSource
import com.app.planner.data.di.MainServiceLocator

class UserRegistrationViewModel: ViewModel() {

   private val userRegistrationLocalDataSource: UserRegistrationLocalDataSource by lazy {
        MainServiceLocator.userRegistrationLocalDataSource
    }

    fun getIsUserRegistered(): Boolean{
        return userRegistrationLocalDataSource.getIsUserRegistered()
    }

    fun saveIsUserRegistered(isRegistered: Boolean){
        userRegistrationLocalDataSource.saveUserRegistered(isUserRegistered = isRegistered)


    }
}