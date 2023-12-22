package com.kompetisiku.app.data.remote.retrofit

import com.kompetisiku.app.data.remote.response.AuthResponse
import retrofit2.http.*

interface ApiService {

    @FormUrlEncoded
    @POST("register")
    suspend fun register(
        @Field("username") username: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("confirmedPassword") confirmedPassword: String,
        @Field("phone") phone: String,
        @Field("firstName") firstName: String,
        @Field("lastName") lastName: String,
        @Field("gender") gender: String,
        @Field("birth") birth: String,
        @Field("status") status: String
    ): AuthResponse

    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): AuthResponse

    @GET("profile")
    suspend fun getUsers(): AuthResponse

    @GET("profile/{id}")
    suspend fun getUser(
        @Path("id") userId: String
    ): AuthResponse

    @PATCH("profile/{id}")
    suspend fun updateUser(
        @Path("id") userId: String,
        @Body updatedData: UpdateUserData
    ): AuthResponse

    @DELETE("profile/{id}")
    suspend fun deleteUser(
        @Path("id") userId: String
    ): AuthResponse

    data class UpdateUserData(
        @Field("username") val username: String?,
        @Field("password") val password: String?,
        @Field("confirmedPassword") val confirmedPassword: String?,
        @Field("phone") val phone: String?,
        @Field("firstName") val firstName: String?,
        @Field("lastName") val lastName: String?,
        @Field("gender") val gender: String?,
        @Field("birth") val birth: String?,
        @Field("status") val status: String?
    )
}