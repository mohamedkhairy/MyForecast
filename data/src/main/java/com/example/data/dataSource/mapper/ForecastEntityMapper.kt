package com.example.data.dataSource.mapper


import com.example.data.dataSource.loaca.db.*
import com.example.domain.entities.*

fun ForecastEntity?.mappingDomainForecast(): Forecast? {
     this?.run {
       return Forecast(
            id,
            main.mappingToMainEntity(),
            name,
            sys.mappingToSysEntity(),
            weather.mappingToWeatherEntity(),
            wind.mappingToWindEntity()
        )
    } ?: return null
}


fun MainEntity.mappingToMainEntity(): Main =
    Main(humidity , temp , tempMax , tempMin)

fun SysEntity.mappingToSysEntity(): Sys =
    Sys(country , sunrise , sunset)

fun List<WeatherEntity>.mappingToWeatherEntity(): List<Weather> =
    this.map {
        Weather(it.description, it.icon, it.id, it.main)
    }

fun WindEntity.mappingToWindEntity(): Wind =
    Wind(deg, speed)

