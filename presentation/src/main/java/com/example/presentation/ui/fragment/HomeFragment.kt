package com.example.presentation.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.domain.core.Resource
import com.example.presentation.R
import com.example.presentation.databinding.HomeFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var binding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.getForecastByCountry()
        subscribeObservers()
        binding.retry.setOnClickListener {
            homeViewModel.getForecastByCountry()

        }
    }

    private fun subscribeObservers() {
        homeViewModel.dataState.observe(
            viewLifecycleOwner,
            { item ->
                when (item) {
                    is Resource.Loading -> {
                        showLoading()
                    }
                    is Resource.Success -> {
                        item.data?.let {
                            binding.responseTv.text = "$it"
                        }
                        hideLoading()
                    }
                    is Resource.Error -> {
                        hideLoading()
                        item.data?.let {
                            binding.responseTv.text = "$it"
                        }
                        Toast.makeText(requireContext(), "Network ERROR", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            })
    }

    private fun showLoading(){
        binding.loading.visibility = View.VISIBLE
    }

    private fun hideLoading(){
        binding.loading.visibility = View.GONE
    }

}