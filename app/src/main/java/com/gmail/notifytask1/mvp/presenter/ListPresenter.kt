package com.gmail.notifytask1.mvp.presenter

import com.gmail.notifytask1.data.ItemsHolder
import com.gmail.notifytask1.data.MyPreferences
import com.gmail.notifytask1.mvp.contract.ListContract

class ListPresenter(private val preferences: MyPreferences) :
    ListContract.Presenter<ListContract.View>() {

    override fun getItemsList() {
        view?.submitItems(ItemsHolder.items)
    }

    override fun setId(id: Int) {
        preferences.setId(id)
    }
}