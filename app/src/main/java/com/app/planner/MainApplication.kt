package com.app.planner

import android.app.Application
import com.app.planner.core.di.MainServiceLocator

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        MainServiceLocator.initialize(application = this)
    }
}