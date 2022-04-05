package com.gmail.notifytask1.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gmail.notifytask1.data.MyPreferences

@Suppress("UNCHECKED_CAST")
class ListViewModelFactory(
    private val preferences: MyPreferences
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        when (modelClass) {
            ListViewModel::class.java -> return ListViewModel(preferences) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}