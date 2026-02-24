package com.gilorroristore.socioinfonavitandroid.domain.repositories

import com.gilorroristore.socioinfonavitandroid.data.network.model.LoginRequest

interface LoginRepository {
    suspend fun login(creden: LoginRequest) : Boolean
}