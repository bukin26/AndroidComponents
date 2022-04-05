package com.gmail.notifytask1.presentation.main

import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.gmail.notifytask1.R
import com.gmail.notifytask1.data.MyPreferences
import com.gmail.notifytask1.platform.MyBroadcastReceiver
import com.gmail.notifytask1.platform.MyService
import com.gmail.notifytask1.utils.Constants

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by lazy {
        val viewModelFactory = MainViewModelFactory(MyPreferences(applicationContext))
        ViewModelProvider(this, viewModelFactory)
            .get(MainViewModel::class.java)
    }

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
        viewModel.state.observe(this, ::renderState)
        viewModel.sendGetIdIntent()
    }

    private fun renderState(newState: MainState) {
        val bundle = bundleOf(Constants.PREF_KEY to newState.id)
        findNavController(R.id.nav_host_fragment_container).navigate(
            R.id.detailsFragment,
            bundle
        )
    }
}