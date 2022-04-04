package com.gmail.notifytask1.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gmail.notifytask1.repository.ItemsRepository

@Suppress("UNCHECKED_CAST")
class DetailsViewModelFactory(
    private val repository: ItemsRepository,
    private val id: Int
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        when (modelClass) {
            DetailsViewModel::class.java -> return DetailsViewModel(repository, id) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}