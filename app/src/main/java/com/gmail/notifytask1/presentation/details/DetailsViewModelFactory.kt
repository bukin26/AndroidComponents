package com.gmail.notifytask1.presentation.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gmail.notifytask1.base.Interactor

@Suppress("UNCHECKED_CAST")
class DetailsViewModelFactory(
    private val interactors: Set<Interactor<DetailsState, DetailsAction>>,
    private val id: Int
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        when (modelClass) {
            DetailsViewModel::class.java -> return DetailsViewModel(interactors, id) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}
