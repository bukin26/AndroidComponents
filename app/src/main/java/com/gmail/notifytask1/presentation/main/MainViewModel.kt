package com.gmail.notifytask1.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gmail.notifytask1.data.MyPreferences
import com.gmail.notifytask1.utils.Constants
import com.gmail.notifytask1.utils.SingleLiveEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

class MainViewModel(private val preferences: MyPreferences) : ViewModel() {

    private val intents: Channel<MainIntent> = Channel(Channel.UNLIMITED)
    private val _state = SingleLiveEvent<MainState>()
    val state: LiveData<MainState>
        get() = _state

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

    fun sendGetIdIntent() {
        viewModelScope.launch {
            intents.send(MainIntent.GetId)
        }
    }

    private fun getId() {
        preferences.getId().let {
            if (it != Constants.ID_NO_ITEM) _state.value = MainState(id = it)
        }
    }
}