package com.gmail.notifytask1.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gmail.notifytask1.data.MyPreferences
import com.gmail.notifytask1.mvi.MainIntent
import com.gmail.notifytask1.mvi.MainState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

class MainViewModel(private val preferences: MyPreferences) : ViewModel() {

    val intents: Channel<MainIntent> = Channel(Channel.UNLIMITED)
    val state = MutableLiveData<MainState>()

    init {
        handleIntent()
    }

    private fun handleIntent() {
        viewModelScope.launch {
            intents.consumeAsFlow().collect() { intent ->
                if (intent is MainIntent.GetId) getId()
            }
        }
    }

    private fun getId() {
        state.value = MainState.Id(id = preferences.getId())
    }
}