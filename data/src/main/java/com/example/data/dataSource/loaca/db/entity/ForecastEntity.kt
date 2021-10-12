package com.example.data.dataSource.loaca.db.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Forecast")
data class ForecastEntity(
    @PrimaryKey
    val id: Int,
    @Embedded
    val main: MainEntity,
    val name: String,
    @Embedded
    val sys: SysEntity,
    val weather: List<WeatherEntity>,
    @Embedded
    val wind: WindEntity
)



data class MainEntity(
    val humidity: Int,
    val temp: Double,
    val tempMax: Double,
    val tempMin: Double
)

data class SysEntity(
    val country: String,
    val sunrise: Int,
    val sunset: Int,
)

data class WeatherEntity(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)

data class WindEntity(
    val deg: Int,
    val speed: Double
)