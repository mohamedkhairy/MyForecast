package com.example.presentation.utils

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bumptech.glide.GenericTransitionOptions
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.presentation.R
import java.util.*


fun addFragment(incomingFragment: Fragment, tag: String?, activity: AppCompatActivity) {
    val ft = activity.supportFragmentManager.beginTransaction()
//    ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
    ft.add(R.id.screen_area, incomingFragment, tag).addToBackStack(tag)
        .commitAllowingStateLoss()
}

fun getCurrentDateUnix(): String
     = "${System.currentTimeMillis() / 1000}"


fun ImageView.loadAsyncImage(url: String?) {

    Glide.with(this.context).load(url)
        .apply(RequestOptions().override(width, height))
        .centerCrop()
        .transition(GenericTransitionOptions.with<Drawable>(android.R.anim.fade_in)).into(this)

}

fun getImageUrl(icon: String?): String
   =  "https://openweathermap.org/img/wn/${icon ?: "10d"}@2x.png"


fun View.showView() {
    this.visibility = View.VISIBLE
}

fun View.hideView() {
    this.visibility = View.GONE
}

fun View.invisibleView() {
    this.visibility = View.INVISIBLE
}