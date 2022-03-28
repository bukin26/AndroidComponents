package com.gmail.notifytask1

object ItemsHolder {
    val items = MutableList(20) {
        Item(it, "Name $it", "Description $it")
    }
}