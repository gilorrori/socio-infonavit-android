package com.gilorroristore.socioinfonavitandroid.data.network

import com.gilorroristore.socioinfonavitandroid.data.repositories.InfonavitRepositoryImpl
import com.gilorroristore.socioinfonavitandroid.domain.repositories.InfonavitRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
       return Retrofit.Builder()
            .baseUrl("https://www.socioinfonavit.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideInfonavitApiService(retrofit: Retrofit): InfonavitApiService{
        return retrofit.create(InfonavitApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideLoginRepository(infonavitApiService: InfonavitApiService): InfonavitRepository {
        return InfonavitRepositoryImpl(infonavitApiService)
    }

    @Provides
    @Singleton
    fun provideInfonavitRepository(infonavitApiService: InfonavitApiService): InfonavitRepository {
        return InfonavitRepositoryImpl(infonavitApiService)
    }

}