package com.example.domain.useCase

import com.example.domain.core.Resource
import com.example.domain.entities.Forecast
import com.example.domain.entities.ForecastForLastFiveDays
import com.example.domain.repository.ForecastRepository
import com.example.domain.repository.LastFiveDaysRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LastFiveDaysForecastUseCase @Inject constructor(
    private val lastFiveDaysRepository: LastFiveDaysRepository
) {

    suspend operator fun invoke(params: LastFiveDaysParams): Flow<Resource<List<ForecastForLastFiveDays>?>> =
        lastFiveDaysRepository.getForecastForLastFiveDays(params.lat , params.lon , params.date , params.ApiKey)

}

class LastFiveDaysParams(val lat: String = "60.99", val lon: String = "30.9", val date: String , val ApiKey: String)
