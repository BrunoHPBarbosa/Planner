package com.app.planner.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Profile(
    val name: String = "",
    val email: String = "",
    val phone: String = "",
    val image: String  = "" //imagem no formato base64
){
    fun isValid(): Boolean =
         name.isNotEmpty() && email.isNotEmpty() && phone.isNotEmpty() && image.isNotEmpty()

}
