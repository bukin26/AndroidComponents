package com.gmail.notifytask1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class MyBroadcastReceiver(
    private val onClick: () -> Unit
) : BroadcastReceiver() {

    override fun onReceive(p0: Context?, p1: Intent?) {
        onClick()
    }
}