package com.example.data.dataSource.mapper

import com.example.data.dataSource.loaca.db.entity.ForecastLastFiveDaysEntity
import com.example.data.dataSource.remote.model.ForecastForLastFiveDaysResponse
import com.example.domain.entities.ForecastForLastFiveDays


fun List<ForecastLastFiveDaysEntity>.mappingForDomain(): List<ForecastForLastFiveDays> {
    return this.map {
        ForecastForLastFiveDays(
            it.description,
            it.icon,
            it.id,
            it.main,
            it.date
        )
    }
}