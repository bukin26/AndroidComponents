package com.gmail.notifytask1.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gmail.notifytask1.data.MyPreferences

@Suppress("UNCHECKED_CAST")
class MyViewModelFactory(
    private val preferences: MyPreferences
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        when (modelClass) {
            MainViewModel::class.java -> return MainViewModel(preferences) as T
            ListViewModel::class.java -> return ListViewModel(preferences) as T
            DetailsViewModel::class.java -> return DetailsViewModel(preferences) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}