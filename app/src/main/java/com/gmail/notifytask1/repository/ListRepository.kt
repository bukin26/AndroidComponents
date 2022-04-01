package com.gmail.notifytask1.repository

import com.gmail.notifytask1.data.Item
import com.gmail.notifytask1.data.ItemsHolder
import com.gmail.notifytask1.data.MyPreferences

class ListRepository(private val preferences: MyPreferences) {

    fun setId(id: Int) {
        preferences.setId(id)
    }

    fun getItemsList(): List<Item> {
        return ItemsHolder.items
    }
}