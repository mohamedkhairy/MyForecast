package com.example.data.repository

import android.util.Log
import com.example.data.dataSource.loaca.db.ForecastDao
import com.example.data.dataSource.mapper.mappingDomainForecast
import com.example.data.dataSource.mapper.mappingForecast
import com.example.data.dataSource.remote.Endpoints
import com.example.data.utils.networkBoundResource
import com.example.domain.core.Resource
import com.example.domain.entities.Forecast
import com.example.domain.repository.ForecastRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class ForecastRepositoryImp @Inject constructor(val endpoints: Endpoints , val forecastDao: ForecastDao) : ForecastRepository {

    override suspend fun getForecastByCountryName(country: String?, ApiKey: String): Flow<Resource<Forecast?>>
    =  networkBoundResource(
            query = {
                    forecastDao.getAll().map {savedData ->
                        savedData?.mappingDomainForecast()
                    }
            },
            fetch = {
                val response = endpoints.callForecastByCountryName(country, ApiKey)
                response.mappingForecast()
            },
            saveFetchResult = { data ->
                forecastDao.deleteAll()
                forecastDao.save(data)
                data.mappingDomainForecast()
            }
        ).onStart {
        emit(Resource.Loading(null))
        }
        .flowOn(Dispatchers.IO)



}