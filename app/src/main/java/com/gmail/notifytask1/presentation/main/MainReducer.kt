package com.gmail.notifytask1.presentation.main

import com.gmail.notifytask1.base.Reducer
import com.gmail.notifytask1.utils.Constants

class MainReducer : Reducer<MainState, MainAction> {

    override val initialState = MainState(
        id = Constants.ID_NO_ITEM
    )

    override fun reduce(state: MainState, action: MainAction): MainState {
        return when (action) {
            MainAction.None -> state
            MainAction.LoadId -> state
            is MainAction.IdLoaded -> state.copy(
                id = action.id
            )
            is MainAction.Error -> state
        }
    }
}