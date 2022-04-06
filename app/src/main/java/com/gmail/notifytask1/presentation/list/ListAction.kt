package com.gmail.notifytask1.presentation.list

import com.gmail.notifytask1.data.Item

sealed class ListAction {

    object None : ListAction()
    object LoadItems : ListAction()
    data class SetId(val id: Int) : ListAction()
    data class ItemsLoaded(val items: List<Item>) : ListAction()
    data class Error(val error: Exception) : ListAction()
}