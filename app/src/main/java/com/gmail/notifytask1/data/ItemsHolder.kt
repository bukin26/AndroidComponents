package com.gmail.notifytask1.data

object ItemsHolder {

    val items = MutableList(20) {
        Item(it, "Name $it", "Description $it")
    }

    fun getItemById(id: Int): Item? {
        return items.find { item -> item.id == id }
    }
}