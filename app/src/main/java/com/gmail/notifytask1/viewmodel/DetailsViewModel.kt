package com.gmail.notifytask1.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gmail.notifytask1.data.ItemsHolder
import com.gmail.notifytask1.data.MyPreferences
import com.gmail.notifytask1.mvi.MainIntent
import com.gmail.notifytask1.mvi.MainState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

class DetailsViewModel(private val preferences: MyPreferences) : ViewModel() {

    val intents: Channel<MainIntent> = Channel(Channel.UNLIMITED)
    val state = MutableLiveData<MainState>()

    init {
        handleIntent()
    }

    private fun handleIntent() {
        viewModelScope.launch {
            intents.consumeAsFlow().collect() { intent ->
                if (intent is MainIntent.GetItem) getItem(intent.id)
            }
        }
    }

    private fun getItem(id: Int) {
        ItemsHolder.getItemById(id)?.let {
            state.value = MainState.DetailedItem(item = it)
        }
    }
}