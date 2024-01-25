package com.myself223.card

import android.app.Application
import com.myself223.card.data.shared.Prefs

class App : Application() {
    companion object{
        lateinit var prefs: Prefs
    }

    override fun onCreate() {
        super.onCreate()
        prefs = Prefs(this)
    }
}