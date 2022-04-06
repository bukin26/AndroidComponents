package com.gmail.notifytask1.presentation.list

import com.gmail.notifytask1.base.Reducer

class ListReducer : Reducer<ListState, ListAction> {

    override val initialState = ListState(
        items = listOf()
    )

    override fun reduce(state: ListState, action: ListAction): ListState {
        return when (action) {
            ListAction.None -> state
            ListAction.LoadItems -> state
            is ListAction.SetId -> state
            is ListAction.ItemsLoaded -> state.copy(
                items = action.items
            )
            is ListAction.Error -> state
        }
    }
}