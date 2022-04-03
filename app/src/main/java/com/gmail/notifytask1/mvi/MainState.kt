package com.gmail.notifytask1.mvi

import com.gmail.notifytask1.data.Item

sealed class MainState {

    data class Items(val items: List<Item>) : MainState()
    data class DetailedItem(val item: Item) : MainState()
    data class Id(val id: Int) : MainState()
}