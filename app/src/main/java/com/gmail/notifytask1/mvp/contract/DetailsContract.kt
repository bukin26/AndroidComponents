package com.gmail.notifytask1.mvp.contract

import com.gmail.notifytask1.data.Item
import com.gmail.notifytask1.mvp.base.BaseMvpPresenter
import com.gmail.notifytask1.mvp.base.BaseMvpView

interface DetailsContract {

    interface View : BaseMvpView

    interface Presenter : BaseMvpPresenter<View> {

        fun getItem(id: Int): Item?
    }

}