package com.gmail.notifytask1.presentation.details

import com.gmail.notifytask1.data.Item

sealed class DetailsAction {

    object None : DetailsAction()
    object Load : DetailsAction()
    data class ItemLoaded(val item: Item?) : DetailsAction()
    data class Error(val error: Exception) : DetailsAction()

}