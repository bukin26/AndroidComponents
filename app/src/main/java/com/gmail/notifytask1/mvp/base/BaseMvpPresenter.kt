package com.gmail.notifytask1.mvp.base

abstract class BaseMvpPresenter<V : BaseMvpView> {

    protected var view: V? = null

    fun attachView(view: V) {
        this.view = view
    }

    fun detachView() {
        view = null
    }
}