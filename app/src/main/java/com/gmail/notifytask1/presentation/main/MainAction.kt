package com.gmail.notifytask1.presentation.main

sealed class MainAction {

    object None : MainAction()
    object LoadId : MainAction()
    data class IdLoaded(val id: Int) : MainAction()
    data class Error(val error: Exception) : MainAction()
}