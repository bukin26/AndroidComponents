package com.gmail.notifytask1.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import com.gmail.notifytask1.data.ItemsHolder
import com.gmail.notifytask1.data.MyPreferences
import com.gmail.notifytask1.mvi.MainIntent
import com.gmail.notifytask1.mvi.MainState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

class ListViewModel(private val preferences: MyPreferences) : ViewModel() {

    val intents: Channel<MainIntent> = Channel(Channel.UNLIMITED)
    val state = MutableLiveData<MainState>(MainState.Items(items = ItemsHolder.items))

    init {
        handleIntent()
    }

    private fun handleIntent() {
        viewModelScope.launch {
            intents.consumeAsFlow().collect() { intent ->
                if (intent is MainIntent.SetId) setId(intent.id)
            }
        }
    }

    private fun setId(id: Int) {
        preferences.setId(id)
    }
}