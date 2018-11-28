package com.example.elina.musicplayer

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import com.example.elina.musicplayer.R.id.*

import java.util.ArrayList

class MusicController : Callback, SharedPreferences.OnSharedPreferenceChangeListener, AppCompatActivity() {
    private lateinit var prev: Button
    private lateinit var next: Button
    private lateinit var play: Button
    private lateinit var change: Button
    private lateinit var nameOfSong: TextView
    private lateinit var artist: TextView
    private var position: Int = 0
    private lateinit var mediaPlayer: MusicService
    private var songs: ArrayList<Song> = MainActivity.getSongList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

        val prev = btn_prev
        val next = btn_next
        val play = btn_play
        val change = btn_settings
        val nameOfSong = tv_title
        val artist = tv_artist
        position = getIntent().getIntExtra("position", 0)

        prev.setOnClickListener {
            position--
            position = if (position == -1) songs.size - 1 else position
            mediaPlayer.playPrev()
        }

        next.setOnClickListener {
            position++
            position = if (position == songs.size) 0 else position
            mediaPlayer.playNext()
        }

        play.setOnClickListener {
            mediaPlayer.go()
        }

        val sharedPref = PreferenceManager.getDefaultSharedPreferences(this)
        val currentTheme = sharedPref.getString("pref_theme", "pref_theme_default")
        var themeId = R.style.Theme1
        when (currentTheme) {
            "Theme1" -> themeId = R.style.Theme1
            "Theme2" -> themeId = R.style.Theme2
            "Theme3" -> themeId = R.style.Theme3
            else -> themeId = R.style.Theme1
        }
        setTheme(themeId)

        val intent = Intent(this, MusicService::class.java)
        startService(intent)
        bindService(intent, this, Context.BIND_AUTO_CREATE)

        change.setOnClickListener {
            val intent = Intent(getApplicationContext(), SettingsActivity::class.java)
            startActivity(intent)
        }
    }

    override fun exactSong(id: Int) {
        position = id
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences, key: String) {
        recreate()
    }
}
