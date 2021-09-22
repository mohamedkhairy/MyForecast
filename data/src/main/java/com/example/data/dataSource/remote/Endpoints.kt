package com.example.data.dataSource.remote

import com.example.data.dataSource.remote.model.ForecastResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Endpoints {

    @GET("data/2.5/weather")
    suspend fun callForecastByCountryName(
        @Query("q") country: String?,
        @Query("appid") ApiKey: String
    ): ForecastResponse


    @GET("data/2.5/weather")
    suspend fun callForecastByLatLon(
        @Query("lat") lat: String?,
        @Query("lon") lon: String?,
        @Query("appid") ApiKey: String
    ): ForecastResponse

}