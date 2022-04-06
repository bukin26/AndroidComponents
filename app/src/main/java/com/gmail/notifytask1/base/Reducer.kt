package com.gmail.notifytask1.base

interface Reducer<State, Action> {

    val initialState: State

    fun reduce(state: State, action: Action): State
}