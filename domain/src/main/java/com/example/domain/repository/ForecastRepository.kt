package com.example.domain.repository


import com.example.domain.core.Resource
import com.example.domain.entities.Forecast
import kotlinx.coroutines.flow.Flow

interface ForecastRepository {

    suspend fun getForecastByCountryName(country: String?, ApiKey: String): Flow<Resource<Forecast?>>



}