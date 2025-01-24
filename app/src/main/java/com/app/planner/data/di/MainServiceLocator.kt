package com.app.planner.data.di

import android.app.Application
import com.app.planner.data.datasource.UserRegistrationLocalDataSource
import com.app.planner.data.datasource.UserRegistrationLocalDataSourceImpl

object MainServiceLocator {

    private  var _application: Application? = null
    private val application get() = _application!!


    val userRegistrationLocalDataSource: UserRegistrationLocalDataSource by lazy{
        UserRegistrationLocalDataSourceImpl(applicationContext = application.applicationContext)
    }
    fun initialize(application: Application) {
        _application = application
    }

    fun clear(){
        _application = null

    }
}