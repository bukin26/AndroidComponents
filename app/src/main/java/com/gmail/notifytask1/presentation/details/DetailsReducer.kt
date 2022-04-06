package com.gmail.notifytask1.presentation.details

import com.gmail.notifytask1.base.Reducer

class DetailsReducer(itemId: Int) : Reducer<DetailsState, DetailsAction> {

    override val initialState = DetailsState(
        itemId = itemId,
        item = null
    )

    override fun reduce(state: DetailsState, action: DetailsAction): DetailsState {
        return when (action) {
            DetailsAction.None -> state
            DetailsAction.Load -> state
            is DetailsAction.ItemLoaded -> state.copy(
                item = action.item
            )
            is DetailsAction.Error -> state
        }
    }
}