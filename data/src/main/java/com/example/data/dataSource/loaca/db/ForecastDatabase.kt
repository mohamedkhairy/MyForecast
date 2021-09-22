package com.example.data.dataSource.loaca.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = [ForecastEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class ForecastDatabase : RoomDatabase() {

    abstract fun forecastDao(): ForecastDao

}
