package com.gmail.notifytask1.presentation.details

import com.gmail.notifytask1.data.Item

data class DetailsState(
    val itemId: Int,
    val item: Item?
)