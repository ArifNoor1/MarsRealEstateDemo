package com.example.marsrealestatedemo.remote

import com.example.marsrealestatedemo.local.Mars
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {
    @GET(EndPoint.realEstate)
    suspend fun getProperties(@Query("filter") type: String): List<Mars>
}
