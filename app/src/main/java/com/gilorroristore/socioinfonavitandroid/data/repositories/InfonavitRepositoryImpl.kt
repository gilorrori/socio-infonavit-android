package com.gilorroristore.socioinfonavitandroid.data.repositories

import com.gilorroristore.socioinfonavitandroid.data.network.InfonavitApiService
import com.gilorroristore.socioinfonavitandroid.domain.repositories.InfonavitRepository
import javax.inject.Inject

class InfonavitRepositoryImpl @Inject constructor(private  val infonavitApiService: InfonavitApiService) : InfonavitRepository {

    override suspend fun getBenevits() {
        infonavitApiService.getBenevits()
    }

}