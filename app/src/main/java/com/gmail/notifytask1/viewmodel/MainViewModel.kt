package com.gmail.notifytask1.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.gmail.notifytask1.data.MyPreferences
import com.gmail.notifytask1.repository.MainRepository

class MainViewModel(app: Application) : AndroidViewModel(app) {

    private val repository = MainRepository(MyPreferences(getApplication()))

    fun getId(): Int {
        return repository.getId()
    }
}