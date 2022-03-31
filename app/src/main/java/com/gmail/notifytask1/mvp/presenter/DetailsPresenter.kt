package com.gmail.notifytask1.mvp.presenter

import com.gmail.notifytask1.data.Item
import com.gmail.notifytask1.data.ItemsHolder
import com.gmail.notifytask1.mvp.contract.DetailsContract

class DetailsPresenter :
    DetailsContract.Presenter<DetailsContract.View>() {

    override fun getItem(id: Int) {
        val item: Item? = ItemsHolder.getItemById(id)
        view?.setItemText(item)
    }
}