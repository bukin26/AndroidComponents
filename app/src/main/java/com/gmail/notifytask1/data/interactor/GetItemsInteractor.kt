package com.gmail.notifytask1.data.interactor

import com.gmail.notifytask1.base.Interactor
import com.gmail.notifytask1.data.ItemsHolder
import com.gmail.notifytask1.presentation.list.ListAction
import com.gmail.notifytask1.presentation.list.ListState

class GetItemsInteractor : Interactor<ListState, ListAction> {

    override suspend fun invoke(state: ListState, action: ListAction): ListAction {
        return if (action is ListAction.LoadItems) {
            ListAction.ItemsLoaded(ItemsHolder.items)
        } else {
            ListAction.Error(IllegalArgumentException("Wrong action: $action"))
        }
    }

    override fun canHandle(action: ListAction): Boolean {
        return action is ListAction.LoadItems
    }

}