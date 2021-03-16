package com.example.umbrella.utils

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesManager(context: Context) {
    private val prefrences: SharedPreferences = context.getSharedPreferences("prefs", Context.MODE_PRIVATE)

    fun putUsername(username: String){
        val editor: SharedPreferences.Editor = prefrences.edit()
        editor.putString(USERNAME, username)
        editor.apply()
    }

    fun putLastName(lastName: String){
        val editor: SharedPreferences.Editor = prefrences.edit()
        editor.putString(LASTNAME, lastName)
        editor.apply()
    }

    fun getUsername():String? = prefrences.getString(USERNAME, null)
    fun getLastName():String? = prefrences.getString(LASTNAME, null)
}