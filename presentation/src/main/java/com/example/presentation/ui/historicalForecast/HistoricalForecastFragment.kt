package com.example.presentation.ui.historicalForecast

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.core.Resource
import com.example.domain.entities.ForecastForLastFiveDays
import com.example.presentation.databinding.HistoricalForecastFragmentBinding
import com.example.presentation.ui.historicalForecast.adapter.HistoricalAdapter
import com.example.presentation.utils.hideView
import com.example.presentation.utils.showView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoricalForecastFragment : Fragment() {

    private val historicalForecastViewModel: HistoricalForecastViewModel by viewModels()

    private lateinit var binding: HistoricalForecastFragmentBinding
    private lateinit var historicalAdapter: HistoricalAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = HistoricalForecastFragmentBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        getHistoricalForecast()
        subscribeObservers()

        binding.retry.setOnClickListener {
            getHistoricalForecast()
        }
    }


    private fun initView(){
        with(binding.recyclerView) {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            historicalAdapter = HistoricalAdapter {  }
            this.adapter = historicalAdapter
        }
    }

    private fun getHistoricalForecast(){
        historicalForecastViewModel.getLastFiveDaysForecast()
    }

    private fun subscribeObservers() {
        historicalForecastViewModel.dataState.observe(
            viewLifecycleOwner,
            { item ->
                when (item) {
                    is Resource.Loading -> {
                        showLoading()
                    }
                    is Resource.Success -> {
                        item.data?.let {
                            showData()
                            setHistoricalList(it)
                        }
                        hideLoading()
                    }
                    is Resource.Error -> {
                        hideLoading()

                        item.error?.printStackTrace()

                        item.data?.let {
                            showData()
                            setHistoricalList(it)
                        } ?: hideData()

                        Toast.makeText(requireContext(), "Network ERROR", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            })
    }

    private fun setHistoricalList(list: List<ForecastForLastFiveDays>) {
        historicalAdapter.items = list
    }


    private fun showData(){
        binding.recyclerView.showView()
    }

    private fun hideData(){
        binding.recyclerView.hideView()
    }

    private fun showLoading(){
        binding.loading.showView()
    }

    private fun hideLoading(){
        binding.loading.hideView()
    }

}