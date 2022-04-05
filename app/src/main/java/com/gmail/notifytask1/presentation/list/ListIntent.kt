package com.gmail.notifytask1.presentation.list

sealed class ListIntent {

    class SetId(val id: Int) : ListIntent()
}