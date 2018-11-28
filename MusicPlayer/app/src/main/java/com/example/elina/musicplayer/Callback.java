package com.example.elina.musicplayer;

import android.content.SharedPreferences;

public interface Callback {
    void exactSong(int position);
    void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key);
}
