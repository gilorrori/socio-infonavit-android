package com.gilorroristore.socioinfonavitandroid.data.network

import com.gilorroristore.socioinfonavitandroid.core.Constants
import com.gilorroristore.socioinfonavitandroid.data.network.model.BenevitsResponse
import com.gilorroristore.socioinfonavitandroid.data.network.model.LoginRequest
import com.gilorroristore.socioinfonavitandroid.data.network.model.LoginResponse
import retrofit2.http.GET
import retrofit2.http.POST

interface InfonavitApiService {
    @POST(Constants.LOGIN_ENDPOINT)
    suspend fun login(credentials: LoginRequest) : LoginResponse

    @GET(Constants.BENEVITS_ENDPOINT)
    suspend fun getBenevits() : BenevitsResponse
}