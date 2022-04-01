package com.gmail.notifytask1.repository

import com.gmail.notifytask1.data.Item
import com.gmail.notifytask1.data.ItemsHolder

class DetailsRepository {

    fun getItem(id: Int): Item? {
        return ItemsHolder.getItemById(id)
    }
}