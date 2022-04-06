package com.gmail.notifytask1.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gmail.notifytask1.base.Interactor

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(
    private val interactors: Set<Interactor<MainState, MainAction>>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        when (modelClass) {
            MainViewModel::class.java -> return MainViewModel(interactors) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}