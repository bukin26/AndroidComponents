package com.gmail.notifytask1.mvp.presenter

import com.gmail.notifytask1.data.Item
import com.gmail.notifytask1.data.ItemsHolder
import com.gmail.notifytask1.mvp.base.BaseMvpPresenterImpl
import com.gmail.notifytask1.mvp.contract.DetailsContract

class DetailsPresenter : BaseMvpPresenterImpl<DetailsContract.View>(), DetailsContract.Presenter {

    override fun getItem(id: Int): Item? {
        return ItemsHolder.getItemById(id)
    }
}