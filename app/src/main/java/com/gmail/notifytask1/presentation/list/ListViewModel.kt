package com.gmail.notifytask1.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gmail.notifytask1.data.Item
import com.gmail.notifytask1.repository.ItemsRepository

class ListViewModel(private val repository: ItemsRepository) : ViewModel() {

    private val _items = MutableLiveData<List<Item>>()
    val items: LiveData<List<Item>>
        get() = _items

    fun setId(id: Int) {
        repository.setId(id)
    }

    fun getItemsList() {
        _items.value = repository.getItemsList()
    }
}