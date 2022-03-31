package com.gmail.notifytask1.presentation

import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import com.gmail.notifytask1.R
import com.gmail.notifytask1.data.MyPreferences
import com.gmail.notifytask1.databinding.ActivityMainBinding
import com.gmail.notifytask1.mvp.contract.MainContract
import com.gmail.notifytask1.mvp.presenter.MainPresenter
import com.gmail.notifytask1.platform.MyBroadcastReceiver
import com.gmail.notifytask1.platform.MyService
import com.gmail.notifytask1.utils.Constants


class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var pref: MyPreferences
    private lateinit var presenter: MainPresenter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
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
        pref = MyPreferences(this)
        presenter = MainPresenter(pref)
        presenter.attachView(this)
    }


    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        val id = presenter.getId()
        if (id != -1) {
            val bundle = bundleOf(Constants.PREF_KEY to id)
            binding.navHostFragmentContainer.getFragment<NavHostFragment>().navController.navigate(
                R.id.detailsFragment,
                bundle
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}