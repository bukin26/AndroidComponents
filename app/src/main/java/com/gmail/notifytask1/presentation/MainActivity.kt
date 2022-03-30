package com.gmail.notifytask1.presentation

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.gmail.notifytask1.R
import com.gmail.notifytask1.platform.MyBroadcastReceiver
import com.gmail.notifytask1.platform.MyService
import com.gmail.notifytask1.utils.Constants


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Intent(this, MyService::class.java).also { intent ->
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                startForegroundService(intent)
            } else {
                startService(intent)
            }
        }
        val myBroadcastReceiver = MyBroadcastReceiver()
        val intentFilter = IntentFilter()
        intentFilter.addAction(Constants.MY_BROADCAST)
        registerReceiver(myBroadcastReceiver, intentFilter)
    }


    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        val sharedPref = this.getSharedPreferences(Constants.MY_PREFERENCES, Context.MODE_PRIVATE)
        val id = sharedPref.getInt(Constants.PREF_KEY, -1)
        Log.d("TAG", "onNewIntent: $id")
        if (id != -1) {
            val bundle = bundleOf(Constants.PREF_KEY to id)
            findNavController(R.id.nav_host_fragment_container).navigate(
                R.id.detailsFragment,
                bundle
            )
        }
    }
}