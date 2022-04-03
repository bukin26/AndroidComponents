package com.gmail.notifytask1.presentation

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
import com.gmail.notifytask1.repository.ItemsRepository
import com.gmail.notifytask1.utils.Constants
import com.gmail.notifytask1.viewmodel.MainViewModel
import com.gmail.notifytask1.viewmodel.MyViewModelFactory


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var viewModelFactory: MyViewModelFactory
    private lateinit var repository: ItemsRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        repository = ItemsRepository(MyPreferences(applicationContext))
        viewModelFactory = MyViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(MainViewModel::class.java)

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
        viewModel.id.observe(this) { id ->
            if (id != -1) {
                val bundle = bundleOf(Constants.PREF_KEY to id)
                findNavController(R.id.nav_host_fragment_container).navigate(
                    R.id.detailsFragment,
                    bundle
                )
            }
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        viewModel.getId()
    }
}