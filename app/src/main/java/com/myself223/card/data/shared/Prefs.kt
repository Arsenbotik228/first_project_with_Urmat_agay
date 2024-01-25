package com.myself223.card.data.shared

import android.content.Context
import android.content.Context.MODE_PRIVATE

class Prefs(context: Context) {

    private val prefs = context.getSharedPreferences("prefs" , MODE_PRIVATE)

    fun isShow(): Boolean{
        return prefs.getBoolean("onBoard" , false)
    }
    fun changeShow(show :Boolean){
        prefs.edit().putBoolean("onBoard",show).apply()
    }
}
