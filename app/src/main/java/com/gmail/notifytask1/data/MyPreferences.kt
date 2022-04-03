package com.gmail.notifytask1.data

import android.content.Context
import androidx.core.content.edit
import com.gmail.notifytask1.utils.Constants

class MyPreferences(context: Context) {

    private val pref = context.getSharedPreferences(
        Constants.MY_PREFERENCES,
        Context.MODE_PRIVATE
    )

    fun setId(id: Int) {
        pref.edit {
            putInt(Constants.PREF_KEY, id)
        }
    }

    fun getId(): Int {
        return pref.getInt(Constants.PREF_KEY, -1)
    }
}