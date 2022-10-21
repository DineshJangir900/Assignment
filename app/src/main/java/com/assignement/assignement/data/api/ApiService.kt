package com.assignement.assignement.data.api

import com.assignement.assignement.data.model.UserDetailsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api")
    suspend fun getUsers(@Query("results") results: Int): Response<UserDetailsResponse>
}