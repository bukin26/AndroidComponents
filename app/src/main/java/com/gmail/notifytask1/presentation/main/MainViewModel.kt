package com.gmail.notifytask1.presentation.main

import com.gmail.notifytask1.base.BaseViewModel
import com.gmail.notifytask1.base.Interactor

class MainViewModel(
    interactors: Set<Interactor<MainState, MainAction>>
) : BaseViewModel<MainState, MainAction>(
    interactors = interactors,
    reducer = MainReducer()
) {

    fun getId() {
        action(MainAction.LoadId)
    }
}