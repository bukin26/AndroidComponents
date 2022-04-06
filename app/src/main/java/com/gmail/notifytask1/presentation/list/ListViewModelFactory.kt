package com.gmail.notifytask1.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gmail.notifytask1.base.Interactor

@Suppress("UNCHECKED_CAST")
class ListViewModelFactory(
    private val interactors: Set<Interactor<ListState, ListAction>>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        when (modelClass) {
            ListViewModel::class.java -> return ListViewModel(interactors) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}