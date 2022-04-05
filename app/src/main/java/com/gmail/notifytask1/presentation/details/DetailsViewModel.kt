package com.gmail.notifytask1.presentation.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gmail.notifytask1.data.ItemsHolder

class DetailsViewModel(id: Int) : ViewModel() {

    private val _state = MutableLiveData<DetailsState>()
    val state: LiveData<DetailsState>
        get() = _state

    init {
        getItem(id)
    }

    private fun getItem(id: Int) {
        ItemsHolder.getItemById(id)?.let {
            _state.value = DetailsState(item = it)
        }
    }
}