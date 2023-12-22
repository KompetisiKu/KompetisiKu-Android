package com.kompetisiku.app.di

import com.kompetisiku.app.BuildConfig
import com.kompetisiku.app.data.remote.retrofit.ApiService
import com.kompetisiku.app.data.repository.KompetisiKuRepositoryImpl
import com.kompetisiku.app.domain.repository.KompetisiKuRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideKompetisiKuRepository(apiService: ApiService): KompetisiKuRepository {
        return KompetisiKuRepositoryImpl(apiService)
    }
}