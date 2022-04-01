package com.gmail.notifytask1.repository

import com.gmail.notifytask1.data.MyPreferences

class MainRepository(private val preferences: MyPreferences) {

    fun getId(): Int {
        return preferences.getId()
    }
}