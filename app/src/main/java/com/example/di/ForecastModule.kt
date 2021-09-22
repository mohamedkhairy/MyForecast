package com.example.di

import com.example.data.dataSource.loaca.db.ForecastDao
import com.example.data.dataSource.remote.Endpoints
import com.example.data.repository.ForecastRepositoryImp
import com.example.domain.repository.ForecastRepository
import com.example.domain.useCase.CountryForecastUSeCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
object ForecastModule {

    @ViewModelScoped
    @Provides
    fun provideForecastRepository(endpoints: Endpoints, forecastDao: ForecastDao): ForecastRepository {
        return ForecastRepositoryImp(endpoints, forecastDao)
    }

    @ViewModelScoped
    @Provides
    fun provideCountryForecastUSeCase(forecastRepository: ForecastRepository): CountryForecastUSeCase {
        return CountryForecastUSeCase(forecastRepository)
    }
}