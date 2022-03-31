package com.gmail.notifytask1.mvp.presenter

import com.gmail.notifytask1.data.MyPreferences
import com.gmail.notifytask1.mvp.contract.MainContract

class MainPresenter(private val preferences: MyPreferences) :
    MainContract.Presenter<MainContract.View>() {

    override fun getId() {
        val id = preferences.getId()
        view?.navigateToDetails(id)
    }
}