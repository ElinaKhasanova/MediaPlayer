package com.example.elina.musicplayer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MusicController implements Callback, SharedPreferences.OnSharedPreferenceChangeListener {
    Button prev;
    Button next;
    Button play;
    Button change;
    TextView nameOfSong;
    TextView artist;
    int position;
    MusicService mediaPlayer;
    ArrayList<Song> songs = MainActivity.getSongList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        prev = findViewById(R.id.btn_prev);
        next = findViewById(R.id.btn_next);
        play = findViewById(R.id.btn_play);
        change = findViewById(R.id.btn_settings);
        nameOfSong = findViewById(R.id.tv_title);
        artist = findViewById(R.id.tv_artist);
        position = getIntent().getIntExtra("position", 0);

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position--;
                position = position == -1 ? songs.size() - 1 : position;
                mediaPlayer.playPrev();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position++;
                position = position == songs.size() ? 0 : position;
                mediaPlayer.playNext();
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.go();
            }
        });

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String currentTheme = sharedPref.getString("pref_theme","pref_theme_default");
        int themeId = R.style.Theme1;
        switch (currentTheme) {
            case ("Theme1"):
                themeId = R.style.Theme1;
                break;
            case ("Theme2"):
                themeId = R.style.Theme2;
                break;
            case ("Theme3"):
                themeId = R.style.Theme3;
                break;
            default: themeId = R.style.Theme1;
        }
        setTheme(themeId);


        Intent intent = new Intent(this, MusicService.class);
        startService(intent);
        bindService(intent, this, Context.BIND_AUTO_CREATE);

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void exactSong(int id) {
        position = id;
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        recreate();
    }
}
