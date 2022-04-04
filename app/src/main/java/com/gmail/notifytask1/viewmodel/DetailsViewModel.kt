package com.gmail.notifytask1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gmail.notifytask1.data.Item
import com.gmail.notifytask1.repository.ItemsRepository

class DetailsViewModel(
    private val repository: ItemsRepository,
    private val id: Int
) : ViewModel() {

    private val _item = MutableLiveData<Item>()
    val item: LiveData<Item>
        get() = _item

    init {
        getItem()
    }

    private fun getItem() {
        repository.getItem(id)?.let { _item.value = it }
    }
}