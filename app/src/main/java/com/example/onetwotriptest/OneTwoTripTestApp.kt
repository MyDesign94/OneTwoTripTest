package com.example.onetwotriptest

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class OneTwoTripTestApp: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}