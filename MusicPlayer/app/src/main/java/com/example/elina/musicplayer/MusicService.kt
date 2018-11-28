package com.example.elina.musicplayer

import android.app.Notification
import android.app.PendingIntent
import android.app.Service
import android.content.ContentUris
import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import android.os.PowerManager

import java.util.ArrayList

class MusicService : Service(), MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener {

    private lateinit var player: MediaPlayer
    private lateinit var songs: ArrayList<Song>
    private lateinit var  callback: Callback
    private var  musicBind = MusicBinder()
    private var songPosn: Int = 0

    fun setSongs(songs: ArrayList<Song>) {
        this.songs = songs
    }

    fun setSongPosn(songPosn: Int) {
        this.songPosn = songPosn
    }

    override fun onDestroy() {
        super.onDestroy()
        player.release()
    }

    override fun onCreate() {
        super.onCreate()
        songPosn = 0
        player = MediaPlayer()
        initMusicPlayer()
    }

    fun playSong() {
        player.reset()
        val playSong = songs[songPosn]
        val currSong = playSong.id
        val trackUri = ContentUris.withAppendedId(
                android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                currSong)
        try {
            player.setDataSource(applicationContext, trackUri)
        } catch (ex: Exception) {
            ex.printStackTrace()
        }

        player.prepareAsync()
    }

    fun initMusicPlayer() {
        player.setWakeMode(applicationContext,
                PowerManager.PARTIAL_WAKE_LOCK)
        player.setAudioStreamType(AudioManager.STREAM_MUSIC)
        player.setOnPreparedListener(this)
        player.setOnCompletionListener(this)
        player.setOnErrorListener(this)
    }

    inner class MusicBinder : Binder() {
        internal val service: MusicService
            get() = this@MusicService
    }

    fun pausePlayer() {
        player.pause()
    }

    fun go() {
        if (player.isPlaying) {
            player.stop()
        } else {
            player.start()
        }
    }

    fun playPrev() {
        songPosn--
        songPosn = if (songPosn == -1) songs.size - 1 else songPosn
        callback.exactSong(songPosn)
        player.release()
        playSong()
    }

    fun playNext() {
        songPosn++
        songPosn = if (songPosn == songs.size) 0 else songPosn
        callback.exactSong(songPosn)
        player.release()
        playSong()
    }

    override fun onBind(intent: Intent): IBinder? {
        return musicBind
    }

    override fun onPrepared(mp: MediaPlayer) {
        mp.start()
        val notIntent = Intent(this, MainActivity::class.java)
        notIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendInt = PendingIntent.getActivity(this, 0,
                notIntent, PendingIntent.FLAG_UPDATE_CURRENT)

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val builder = Notification.Builder(this)
            builder.setContentIntent(pendInt)
                    .setSmallIcon(R.drawable.play)
                    .setOngoing(true)
                    .setContentTitle("Title")
                    .setContentText("Notification text")
            val not = builder.build()
            startForeground(1, not)
        }
    }

    override fun onError(mp: MediaPlayer, what: Int, extra: Int): Boolean {
        return false
    }

    override fun onCompletion(mp: MediaPlayer) {
        mp.release()
    }

    override fun onUnbind(intent: Intent): Boolean {
        player.stop()
        player.release()
        return false
    }
}
