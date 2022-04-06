package com.gmail.notifytask1.presentation.list

import com.gmail.notifytask1.base.BaseViewModel
import com.gmail.notifytask1.base.Interactor

class ListViewModel(
    interactors: Set<Interactor<ListState, ListAction>>
) : BaseViewModel<ListState, ListAction>(
    interactors = interactors,
    reducer = ListReducer()
) {

    fun loadItems() {
        action(ListAction.LoadItems)
    }

    fun setId(id: Int) {
        action(ListAction.SetId(id))
    }

}