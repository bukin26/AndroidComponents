package com.gmail.notifytask1.viewmodel

import androidx.lifecycle.ViewModel
import com.gmail.notifytask1.repository.ItemsRepository
import com.gmail.notifytask1.utils.SingleLiveEvent

class MainViewModel(private val repository: ItemsRepository) : ViewModel() {

    val id = SingleLiveEvent<Int>()

    fun getId() {
        id.value = repository.getId()
    }
}