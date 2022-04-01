package com.gmail.notifytask1.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.gmail.notifytask1.data.Item
import com.gmail.notifytask1.repository.DetailsRepository

class DetailsViewModel(app: Application) : AndroidViewModel(app) {

    private val repository = DetailsRepository()

    fun getItem(id: Int): Item? {
        return repository.getItem(id)
    }
}