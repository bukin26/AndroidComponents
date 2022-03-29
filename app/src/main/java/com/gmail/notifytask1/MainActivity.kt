package com.gmail.notifytask1

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation

const val MY_BROADCAST = "com.gmail.notifytask1.broadcast.MY_NOTIFICATION"

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
    }

    override fun onResume() {
        val myBroadcastReceiver = MyBroadcastReceiver { onBroadcastReceive() }
        val intentFilter = IntentFilter()
        intentFilter.addAction(MY_BROADCAST)
        registerReceiver(myBroadcastReceiver, intentFilter)
        super.onResume()
    }

    private fun onBroadcastReceive() {
        val sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
        val id = sharedPreferences.getInt(PREF_KEY, 0)
        val direction = ListFragmentDirections.actionListFragmentToDetailsFragment(id)
        Navigation.findNavController(this, R.id.nav_host_fragment_container).navigate(direction)
    }
}