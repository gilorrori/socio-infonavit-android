package com.gilorroristore.socioinfonavitandroid.data.network.model

data class LoginRequest(
    val credentials: String
)

data class LoginResponse(
    val code: Int,
    val success: Boolean
)

