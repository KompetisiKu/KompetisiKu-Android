package com.kompetisiku.app.domain.repository

interface KompetisiKuRepository {
    suspend fun register()
    suspend fun login()
    suspend fun getUsers()
    suspend fun getUser()
    suspend fun updateUser()
    suspend fun deleteUser()
}