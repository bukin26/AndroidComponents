package com.gmail.notifytask1.mvp.contract

import com.gmail.notifytask1.data.Item
import com.gmail.notifytask1.mvp.base.BaseMvpPresenter
import com.gmail.notifytask1.mvp.base.BaseMvpView

interface ListContract {

    interface View : BaseMvpView

    interface Presenter : BaseMvpPresenter<View> {

        fun getItemsList(): MutableList<Item>

        fun setId(id: Int)
    }
}