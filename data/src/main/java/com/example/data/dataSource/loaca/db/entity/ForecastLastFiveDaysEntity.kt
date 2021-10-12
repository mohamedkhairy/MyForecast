package com.example.data.dataSource.loaca.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "ForecastLastFiveDays")
data class ForecastLastFiveDaysEntity (
    val description: String?,
    val icon: String?,
    @PrimaryKey
    val id: Int?,
    val main: String?,
    val date: String
    )