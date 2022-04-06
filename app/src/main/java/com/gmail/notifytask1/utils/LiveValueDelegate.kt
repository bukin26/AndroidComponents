package com.gmail.notifytask1.utils

import androidx.lifecycle.MutableLiveData
import com.gmail.notifytask1.base.BaseViewModel
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun <T> MutableLiveData<T>.delegate() = LiveValueDelegate(this)

class LiveValueDelegate<T>(
    private val liveData: MutableLiveData<T>
) : ReadWriteProperty<BaseViewModel<*, *>, T> {

    override fun getValue(thisRef: BaseViewModel<*, *>, property: KProperty<*>): T {
        return liveData.value!!
    }

    override fun setValue(thisRef: BaseViewModel<*, *>, property: KProperty<*>, value: T) {
        liveData.value = value
    }
}