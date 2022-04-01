package com.gmail.notifytask1.mvp.contract

import com.gmail.notifytask1.data.Item
import com.gmail.notifytask1.mvp.base.BaseMvpPresenter
import com.gmail.notifytask1.mvp.base.BaseMvpView

interface DetailsContract {

    interface View : BaseMvpView {

        fun setItemText(item: Item)
    }

    abstract class Presenter<T> : BaseMvpPresenter<View>() {

        abstract fun getItem(id: Int)
    }
}