package com.gmail.notifytask1.mvi

sealed class MainIntent {

    class SetId(val id: Int) : MainIntent()
    object GetId : MainIntent()
    class GetItem(val id: Int) : MainIntent()
}