package com.gmail.notifytask1.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gmail.notifytask1.data.Item
import com.gmail.notifytask1.repository.ItemsRepository


class ListViewModel(private val repository: ItemsRepository) : ViewModel() {

    val items = MutableLiveData<List<Item>>()

    fun setId(id: Int) {
        repository.setId(id)
    }

    fun getItemsList(){
        items.value = repository.getItemsList()
    }
}