package com.gmail.notifytask1.platform

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.gmail.notifytask1.presentation.main.MainActivity

class MyBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(p0: Context?, p1: Intent?) {
        val intent = Intent(p0, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        p0?.startActivity(intent)
    }
}