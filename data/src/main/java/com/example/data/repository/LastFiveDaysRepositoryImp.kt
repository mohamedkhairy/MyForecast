package com.example.data.repository

import com.example.data.dataSource.loaca.db.ForecastDao
import com.example.data.dataSource.mapper.mappingForDomain
import com.example.data.dataSource.mapper.mappingForecast
import com.example.data.dataSource.remote.Endpoints
import com.example.data.utils.networkBoundResource
import com.example.domain.core.Resource
import com.example.domain.entities.ForecastForLastFiveDays
import com.example.domain.repository.LastFiveDaysRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class LastFiveDaysRepositoryImp @Inject constructor(val endpoints: Endpoints, val forecastDao: ForecastDao) :
    LastFiveDaysRepository {



    override suspend fun getForecastForLastFiveDays(
        lat: String,
        lon: String,
        date: String,
        ApiKey: String
    ): Flow<Resource<List<ForecastForLastFiveDays>?>> =
        networkBoundResource(
        query = {
            forecastDao.getLastFiveDaysData().map {savedData ->
                savedData?.mappingForDomain()
            }
        },
        fetch = {
            val response = endpoints.callForecastForLastFiveDays(lat , lon , date,  ApiKey)
            response.mappingForecast()
        },
        saveFetchResult = { data ->
            forecastDao.deleteLastFiveDaysData()
            forecastDao.saveLastFiveDaysData(data)
            data.mappingForDomain()
        }
    ).onStart {
        emit(Resource.Loading(null))
    }
        .flowOn(Dispatchers.IO)


}