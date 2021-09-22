package com.example.presentation.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.presentation.R


fun addFragment(incomingFragment: Fragment, tag: String?, activity: AppCompatActivity) {
    val ft = activity.supportFragmentManager.beginTransaction()
//    ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
    ft.add(R.id.screen_area, incomingFragment, tag).addToBackStack(tag)
        .commitAllowingStateLoss()
}