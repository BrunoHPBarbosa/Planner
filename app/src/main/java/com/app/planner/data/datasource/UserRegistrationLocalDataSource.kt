package com.app.planner.data.datasource

import com.app.planner.domain.model.Profile
import kotlinx.coroutines.flow.Flow

interface UserRegistrationLocalDataSource {

    fun getIsUserRegistered(): Boolean

    fun saveUserRegistered(isUserRegistered: Boolean)

    val profile: Flow<Profile>

    suspend fun saveProfile(profile: Profile)
}