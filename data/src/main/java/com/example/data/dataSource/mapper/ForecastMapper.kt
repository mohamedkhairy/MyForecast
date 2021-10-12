package com.example.data.dataSource.mapper

import com.example.data.dataSource.loaca.db.entity.*
import com.example.data.dataSource.remote.model.*


fun ForecastResponse.mappingForecast(): ForecastEntity {
    return ForecastEntity(
        id,
        main.mappingToMainEntity(),
        name,
        sys.mappingToSysEntity(),
        weather.mappingToWeatherEntity(),
        wind.mappingToWindEntity()
    )
}


fun Main.mappingToMainEntity(): MainEntity =
    MainEntity(humidity , temp , tempMax , tempMin)

fun Sys.mappingToSysEntity(): SysEntity =
    SysEntity(country , sunrise , sunset)

fun List<Weather>.mappingToWeatherEntity(): List<WeatherEntity> =
    this.map {
        WeatherEntity(it.description, it.icon, it.id, it.main)
    }

fun Wind.mappingToWindEntity(): WindEntity =
    WindEntity(deg, speed)

