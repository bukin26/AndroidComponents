package com.gmail.notifytask1.mvp.contract

import com.gmail.notifytask1.mvp.base.BaseMvpPresenter
import com.gmail.notifytask1.mvp.base.BaseMvpView

interface MainContract {

    interface View : BaseMvpView {

        fun navigateToDetails(id: Int)
    }

    abstract class Presenter<T> : BaseMvpPresenter<View>() {

        abstract fun getId()
    }
}