package com.kompetisiku.app.data.remote.response

import com.google.gson.annotations.SerializedName

data class UsersResponse(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class DataItem(

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("gender")
	val gender: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("birth")
	val birth: String? = null,

	@field:SerializedName("created at")
	val createdAt: String? = null,

	@field:SerializedName("latest education")
	val latestEducation: String? = null,

	@field:SerializedName("updated at")
	val updatedAt: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("username")
	val username: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)
