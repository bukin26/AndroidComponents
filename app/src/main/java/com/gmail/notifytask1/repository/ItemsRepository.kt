package com.gmail.notifytask1.repository

import com.gmail.notifytask1.data.Item
import com.gmail.notifytask1.data.ItemsHolder
import com.gmail.notifytask1.data.MyPreferences

class ItemsRepository(private val preferences: MyPreferences) {

    fun getItem(id: Int): Item? {
        return ItemsHolder.getItemById(id)
    }

    fun setId(id: Int) {
        preferences.setId(id)
    }

    fun getItemsList(): List<Item> {
        return ItemsHolder.items
    }

    fun getId(): Int {
        return preferences.getId()
    }
}