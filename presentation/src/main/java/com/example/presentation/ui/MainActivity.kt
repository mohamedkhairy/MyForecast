package com.example.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.presentation.R
import com.example.presentation.ui.fragment.HomeFragment
import com.example.presentation.utils.addFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragment(HomeFragment() , HomeFragment::class.simpleName , this)
    }
}