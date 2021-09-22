package com.example.domain.entities



data class Forecast(
    val id: Int,
    val main: Main,
    val name: String,
    val sys: Sys,
    val weather: List<Weather>,
    val wind: Wind
)



data class Main(
    val humidity: Int,
    val temp: Double,
    val tempMax: Double,
    val tempMin: Double
)

data class Sys(
    val country: String,
    val sunrise: Int,
    val sunset: Int,
)

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)

data class Wind(
    val deg: Int,
    val speed: Double
)