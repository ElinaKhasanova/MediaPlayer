package com.example.elina.musicplayer

import android.content.SharedPreferences

interface Callback {
    fun exactSong(position: Int)
    fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences, key: String)
}
