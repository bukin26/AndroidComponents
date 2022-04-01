package com.gmail.notifytask1.mvp.contract

import com.gmail.notifytask1.data.Item
import com.gmail.notifytask1.mvp.base.BaseMvpPresenter
import com.gmail.notifytask1.mvp.base.BaseMvpView

interface ListContract {

    interface View : BaseMvpView {

        fun submitItems(items: List<Item>)
    }

    abstract class Presenter<T> : BaseMvpPresenter<View>() {

        abstract fun getItemsList()

        abstract fun setId(id: Int)
    }
}