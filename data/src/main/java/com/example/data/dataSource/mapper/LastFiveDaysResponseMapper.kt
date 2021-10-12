package com.example.data.dataSource.mapper

import com.example.data.dataSource.loaca.db.entity.ForecastEntity
import com.example.data.dataSource.loaca.db.entity.ForecastLastFiveDaysEntity
import com.example.data.dataSource.remote.model.ForecastForLastFiveDaysResponse
import com.example.data.dataSource.remote.model.ForecastResponse

fun ForecastForLastFiveDaysResponse.mappingForecast(): List<ForecastLastFiveDaysEntity> {
    return hourly.map {
        ForecastLastFiveDaysEntity(
            it.weather.firstOrNull()?.description,
            it.weather.firstOrNull()?.icon,
            it.weather.firstOrNull()?.id,
            it.weather.firstOrNull()?.main,
            it.dt.toRealDate()
        )
    }
}


fun Long?.toRealDate(): String{
    this?.let {
        val sdf = java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        val date = java.util.Date(it * 1000)
        return sdf.format(date)
    } ?: return "_"
}

