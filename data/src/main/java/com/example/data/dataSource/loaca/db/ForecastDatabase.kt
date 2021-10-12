package com.example.data.dataSource.loaca.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.dataSource.loaca.db.entity.ForecastEntity
import com.example.data.dataSource.loaca.db.entity.ForecastLastFiveDaysEntity


@Database(entities = [ForecastEntity::class , ForecastLastFiveDaysEntity::class], version = 2)
@TypeConverters(Converters::class)
abstract class ForecastDatabase : RoomDatabase() {

    abstract fun forecastDao(): ForecastDao

}
