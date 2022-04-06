package com.gmail.notifytask1.data.interactor

import com.gmail.notifytask1.base.Interactor
import com.gmail.notifytask1.data.MyPreferences
import com.gmail.notifytask1.presentation.list.ListAction
import com.gmail.notifytask1.presentation.list.ListState

class SetIdInteractor(private val pref: MyPreferences) : Interactor<ListState, ListAction> {

    override suspend fun invoke(state: ListState, action: ListAction): ListAction {
        return if (action is ListAction.SetId) {
            pref.setId(action.id)
            ListAction.None
        } else {
            ListAction.Error(IllegalArgumentException("Wrong action: $action"))
        }
    }

    override fun canHandle(action: ListAction): Boolean {
        return action is ListAction.SetId
    }
}