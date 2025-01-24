package com.app.planner.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.app.planner.data.datasource.UserRegistrationLocalDataSource
import com.app.planner.data.di.MainServiceLocator
import com.app.planner.data.model.Profile
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class UserRegistrationViewModel: ViewModel() {

   private val userRegistrationLocalDataSource: UserRegistrationLocalDataSource by lazy {
        MainServiceLocator.userRegistrationLocalDataSource
    }

    private val _isProfileValid: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isProfileValid: StateFlow<Boolean> = _isProfileValid.asStateFlow()

    private val _profile: MutableStateFlow<Profile>  = MutableStateFlow(Profile())
    val profile: StateFlow<Profile> = _profile.asStateFlow()

    fun getIsUserRegistered(): Boolean{
        return userRegistrationLocalDataSource.getIsUserRegistered()
    }

    fun saveIsUserRegistered(isRegistered: Boolean){
        userRegistrationLocalDataSource.saveUserRegistered(isUserRegistered = isRegistered)

    }
    fun updateProfile(
        name: String? = null,
        email: String? = null,
        phone: String? = null,
        image: String? = null
    ){
        if (name == null && email == null && phone == null && image == null) return

            _profile.update { currenteProfile ->
                val updatedProfile = currenteProfile.copy(
                    name = name ?: currenteProfile.name,
                    email = email ?: currenteProfile.email,
                    phone = phone ?: currenteProfile.phone,
                    image = image ?: currenteProfile.image

                )
                _isProfileValid.update { updatedProfile.isValid() }
                updatedProfile
            }
        Log.d("UserRegistrationViewModel", "updateProfile: ${_profile.value}")

    }
}