package com.gmail.notifytask1.data.interactor

import com.gmail.notifytask1.base.Interactor
import com.gmail.notifytask1.data.MyPreferences
import com.gmail.notifytask1.presentation.main.MainAction
import com.gmail.notifytask1.presentation.main.MainState

class GetIdInteractor(private val pref: MyPreferences) : Interactor<MainState, MainAction> {

    override suspend fun invoke(state: MainState, action: MainAction): MainAction {
        return if (action is MainAction.LoadId) {
            MainAction.IdLoaded(pref.getId())
        } else {
            MainAction.Error(IllegalArgumentException("Wrong action: $action"))
        }
    }

    override fun canHandle(action: MainAction): Boolean {
        return action is MainAction.LoadId
    }
}