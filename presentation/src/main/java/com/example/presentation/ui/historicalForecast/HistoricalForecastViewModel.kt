package com.example.presentation.ui.historicalForecast

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.core.Resource
import com.example.domain.entities.Forecast
import com.example.domain.entities.ForecastForLastFiveDays
import com.example.domain.useCase.CountryForecastUSeCase
import com.example.domain.useCase.ForecastParams
import com.example.domain.useCase.LastFiveDaysForecastUseCase
import com.example.domain.useCase.LastFiveDaysParams
import com.example.presentation.utils.Contacts
import com.example.presentation.utils.getCurrentDateUnix
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoricalForecastViewModel @Inject constructor (private val lastFiveDaysForecastUseCase: LastFiveDaysForecastUseCase) : ViewModel() {


    private val _dataState: MutableLiveData<Resource<List<ForecastForLastFiveDays>?>> =
        MutableLiveData()

    val dataState: LiveData<Resource<List<ForecastForLastFiveDays>?>>
        get() = _dataState



    fun getLastFiveDaysForecast() {
        viewModelScope.launch(Dispatchers.IO) {

//            lat=30.489772
//            lon=-99.771335

            lastFiveDaysForecastUseCase.invoke(LastFiveDaysParams("60.99" ,"30.9" , getCurrentDateUnix() , Contacts.SERVICE_KEY))
                .catch { exception ->
                    _dataState.postValue(Resource.Error(exception , null))
                }
                .collect {
                    _dataState.postValue(it)
                }
        }

    }
}