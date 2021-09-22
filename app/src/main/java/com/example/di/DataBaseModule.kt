package com.example.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.data.dataSource.loaca.db.ForecastDao
import com.example.data.dataSource.loaca.db.ForecastDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataBaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) : ForecastDatabase =
        Room.databaseBuilder(context, ForecastDatabase::class.java, "forecast_database")
            .build()

    @Provides
    @Singleton
    fun provideForecastDao(database: ForecastDatabase) : ForecastDao =
        database.forecastDao()

}