package com.gmail.notifytask1.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.gmail.notifytask1.repository.ItemsRepository
import com.gmail.notifytask1.utils.Constants
import com.gmail.notifytask1.utils.SingleLiveEvent

class MainViewModel(private val repository: ItemsRepository) : ViewModel() {

    private val _id = SingleLiveEvent<Int>()
    val id: LiveData<Int>
        get() = _id

    fun getId() {
        repository.getId().let {
            if (it != Constants.ID_NO_ITEM) _id.value = it
        }
    }
}