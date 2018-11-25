package com.example.elina.musicplayer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.TextView

import java.util.ArrayList

class SongAdapter(context: Context, private val songs: ArrayList<Song>) : BaseAdapter() {
    private val songInf: LayoutInflater

    init {
        this.songInf = LayoutInflater.from(context)
    }

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
        val songLay = songInf.inflate(R.layout.song, parent, false) as LinearLayout
        val songView = songLay.findViewById<TextView>(R.id.song_title)
        val artistView = songLay.findViewById<TextView>(R.id.song_artist)
        val currSong = songs[position]
        songView.text = currSong.title
        artistView.text = currSong.artist
        songLay.tag = position
        return songLay
    }
}