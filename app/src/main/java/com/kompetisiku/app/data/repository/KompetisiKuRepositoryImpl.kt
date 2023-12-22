package com.kompetisiku.app.data.repository

import com.kompetisiku.app.data.remote.retrofit.ApiService
import com.kompetisiku.app.domain.repository.KompetisiKuRepository

class KompetisiKuRepositoryImpl(
    private val apiService: ApiService
): KompetisiKuRepository {
    override suspend fun register() {}

    override suspend fun login() {}

    override suspend fun getUsers() {}

    override suspend fun getUser() {}

    override suspend fun updateUser() {}

    override suspend fun deleteUser() {}

}