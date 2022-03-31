package com.gmail.notifytask1.mvp.contract

import com.gmail.notifytask1.mvp.base.BaseMvpPresenter
import com.gmail.notifytask1.mvp.base.BaseMvpView

interface MainContract {

    interface View : BaseMvpView

    interface Presenter : BaseMvpPresenter<View> {

        fun getId(): Int
    }
}