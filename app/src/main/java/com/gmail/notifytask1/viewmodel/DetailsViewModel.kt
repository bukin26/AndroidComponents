package com.gmail.notifytask1.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gmail.notifytask1.data.Item
import com.gmail.notifytask1.repository.ItemsRepository

class DetailsViewModel(private val repository: ItemsRepository) : ViewModel() {

    val item = MutableLiveData<Item>()

    fun getItem(id: Int) {
        repository.getItem(id)?.let { item.value = it }
    }
}