package com.example.domain.useCase

import com.example.domain.core.Resource
import com.example.domain.entities.Forecast
import com.example.domain.repository.ForecastRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CountryForecastUSeCase @Inject constructor(
    private val forecastRepository: ForecastRepository
) {

    suspend operator fun invoke(params: ForecastParams): Flow<Resource<Forecast?>> =
        forecastRepository.getForecastByCountryName(params.country , params.ApiKey)

}


class ForecastParams(val country: String?, val ApiKey: String)