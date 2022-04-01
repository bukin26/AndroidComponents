package com.gmail.notifytask1.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.gmail.notifytask1.data.Item
import com.gmail.notifytask1.data.MyPreferences
import com.gmail.notifytask1.repository.ListRepository


class ListViewModel(app: Application) : AndroidViewModel(app) {

    private val repository = ListRepository(MyPreferences(getApplication()))

    fun setId(id: Int) {
        repository.setId(id)
    }

    fun getItemsList(): List<Item>{
        return repository.getItemsList()
    }
}