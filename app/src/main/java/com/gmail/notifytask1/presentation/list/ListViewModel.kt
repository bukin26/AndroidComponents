package com.gmail.notifytask1.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gmail.notifytask1.data.ItemsHolder
import com.gmail.notifytask1.data.MyPreferences
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

class ListViewModel(private val preferences: MyPreferences) : ViewModel() {

    private val intents: Channel<ListIntent> = Channel(Channel.UNLIMITED)
    private val _state = MutableLiveData(ListState(items = ItemsHolder.items))
    val state: LiveData<ListState>
        get() = _state

    init {
        handleIntent()
    }

    private fun handleIntent() {
        viewModelScope.launch {
            intents.consumeAsFlow().collect() { intent ->
                if (intent is ListIntent.SetId) setId(intent.id)
            }
        }
    }

    fun sendSetIdIntent(id: Int) {
        viewModelScope.launch {
            intents.send(ListIntent.SetId(id))
        }
    }

    private fun setId(id: Int) {
        preferences.setId(id)
    }
}