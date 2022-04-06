package com.gmail.notifytask1.presentation.details

import com.gmail.notifytask1.base.BaseViewModel
import com.gmail.notifytask1.base.Interactor

class DetailsViewModel(
    interactors: Set<Interactor<DetailsState, DetailsAction>>,
    id: Int
) : BaseViewModel<DetailsState, DetailsAction>(
    interactors = interactors,
    reducer = DetailsReducer(id)
) {

    fun loadItem() {
        action(DetailsAction.Load)
    }
}