package com.example.presentation.ui.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.core.Resource
import com.example.domain.entities.Forecast
import com.example.domain.useCase.CountryForecastUSeCase
import com.example.domain.useCase.ForecastParams
import com.example.presentation.utils.Contacts.SERVICE_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor (private val countryForecastUSeCase: CountryForecastUSeCase) : ViewModel() {


    private val _dataState: MutableLiveData<Resource<Forecast?>> =
        MutableLiveData()

    val dataState: LiveData<Resource<Forecast?>>
        get() = _dataState



    fun getForecastByCountry() {
        viewModelScope.launch(Dispatchers.IO) {

            countryForecastUSeCase.invoke(ForecastParams("london" , SERVICE_KEY))
                .catch { exception ->
                    _dataState.postValue(Resource.Error(exception , null))
                }
                .collect {
                    _dataState.postValue(it)
                }
        }

    }
}