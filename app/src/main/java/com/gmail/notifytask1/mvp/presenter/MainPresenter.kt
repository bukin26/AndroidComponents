package com.gmail.notifytask1.mvp.presenter

import com.gmail.notifytask1.data.MyPreferences
import com.gmail.notifytask1.mvp.base.BaseMvpPresenterImpl
import com.gmail.notifytask1.mvp.contract.MainContract

class MainPresenter(private val preferences: MyPreferences) :
    BaseMvpPresenterImpl<MainContract.View>(), MainContract.Presenter {

    override fun getId(): Int {
        return preferences.getId()
    }
}