package com.example.di

import com.example.data.dataSource.loaca.db.ForecastDao
import com.example.data.dataSource.remote.Endpoints
import com.example.data.repository.ForecastRepositoryImp
import com.example.data.repository.LastFiveDaysRepositoryImp
import com.example.domain.repository.ForecastRepository
import com.example.domain.repository.LastFiveDaysRepository
import com.example.domain.useCase.CountryForecastUSeCase
import com.example.domain.useCase.LastFiveDaysForecastUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object LastFiveDaysModule {

    @ViewModelScoped
    @Provides
    fun provideLastFiveDaysRepository(endpoints: Endpoints, forecastDao: ForecastDao): LastFiveDaysRepository {
        return LastFiveDaysRepositoryImp(endpoints, forecastDao)
    }

    @ViewModelScoped
    @Provides
    fun provideLastFiveDaysForecastUseCase(lastFiveDaysRepository: LastFiveDaysRepository): LastFiveDaysForecastUseCase {
        return LastFiveDaysForecastUseCase(lastFiveDaysRepository)
    }

}