package com.example.elina.musicplayer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.TextView
import com.example.elina.musicplayer.R.id.song_artist
import com.example.elina.musicplayer.R.id.song_title

import java.util.ArrayList

class SongAdapter(context: Context, private val songs: ArrayList<Song>) : BaseAdapter() {

    override fun getCount(): Int {
        return songs.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View, parent: ViewGroup): View {
        val songView = song_title
        val artistView = song_artist
        val currSong = songs[position]
        songView.text = currSong.title
        artistView.text = currSong.artist
        return songView
    }
}