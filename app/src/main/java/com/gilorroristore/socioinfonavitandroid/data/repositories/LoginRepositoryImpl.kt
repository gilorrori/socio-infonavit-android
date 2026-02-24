package com.gilorroristore.socioinfonavitandroid.data.repositories

import android.util.Log
import com.gilorroristore.socioinfonavitandroid.data.network.InfonavitApiService
import com.gilorroristore.socioinfonavitandroid.data.network.model.LoginRequest
import com.gilorroristore.socioinfonavitandroid.domain.repositories.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(private val infonavitApiService: InfonavitApiService) : LoginRepository {
    val tag: String = LoginRepositoryImpl::class.java.simpleName

    override suspend fun login(creden: LoginRequest): Boolean {
        runCatching { infonavitApiService.login(creden).success }
            .onSuccess { return true }
            .onFailure { Log.e(tag, "Error ${it.message}") }

        Log.d("LoginRepositoryImpl", "login: $creden")
        return creden.credentials.isNotEmpty()
    }
}