package com.example.domain.repository

import com.example.domain.core.Resource
import com.example.domain.entities.Forecast
import com.example.domain.entities.ForecastForLastFiveDays
import kotlinx.coroutines.flow.Flow

interface LastFiveDaysRepository {

    suspend fun getForecastForLastFiveDays(lat: String, lon: String , date: String , ApiKey: String): Flow<Resource<List<ForecastForLastFiveDays>?>>


}