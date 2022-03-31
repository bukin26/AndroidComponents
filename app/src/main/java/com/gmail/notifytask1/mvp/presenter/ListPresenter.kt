package com.gmail.notifytask1.mvp.presenter

import com.gmail.notifytask1.data.Item
import com.gmail.notifytask1.data.ItemsHolder
import com.gmail.notifytask1.data.MyPreferences
import com.gmail.notifytask1.mvp.base.BaseMvpPresenterImpl
import com.gmail.notifytask1.mvp.contract.ListContract

class ListPresenter(private val preferences: MyPreferences) : BaseMvpPresenterImpl<ListContract.View>(), ListContract.Presenter {

    override fun getItemsList(): MutableList<Item> {
        return ItemsHolder.items
    }

    override fun setId(id: Int) {
        preferences.setId(id)
    }
}