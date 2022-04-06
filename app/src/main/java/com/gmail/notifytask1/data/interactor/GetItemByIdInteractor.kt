package com.gmail.notifytask1.data.interactor

import com.gmail.notifytask1.base.Interactor
import com.gmail.notifytask1.data.ItemsHolder
import com.gmail.notifytask1.presentation.details.DetailsAction
import com.gmail.notifytask1.presentation.details.DetailsState

class GetItemByIdInteractor : Interactor<DetailsState, DetailsAction> {

    override suspend fun invoke(
        state: DetailsState,
        action: DetailsAction
    ): DetailsAction {
        return if (action is DetailsAction.Load) {
            try {
                DetailsAction.ItemLoaded(ItemsHolder.getItemById(state.itemId))
            } catch (e: Exception) {
                DetailsAction.Error(e)
            }
        } else {
            DetailsAction.Error(IllegalArgumentException("Wrong action: $action"))
        }
    }

    override fun canHandle(action: DetailsAction): Boolean {
        return action is DetailsAction.Load
    }

}