package com.example.elina.musicplayer;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ContentUris;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.PowerManager;
import android.support.annotation.Nullable;

import java.util.ArrayList;

public class MusicService extends Service implements
        MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener{

    private final IBinder musicBind = new MusicBinder();
    private MediaPlayer player;
    private ArrayList<Song> songs;
    private int songPosn;
    private Callback callback;

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    public void setSongPosn(int songPosn) {
        this.songPosn = songPosn;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.release();
    }

    public void onCreate(){
        super.onCreate();
        songPosn = 0;
        player = new MediaPlayer();
        initMusicPlayer();
    }

    public void playSong(){
        player.reset();
        Song playSong = songs.get(songPosn);
        long currSong = playSong.getId();
        Uri trackUri = ContentUris.withAppendedId(
                android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                currSong);
        try{
            player.setDataSource(getApplicationContext(), trackUri);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        player.prepareAsync();
    }

    public void initMusicPlayer(){
        player.setWakeMode(getApplicationContext(),
                PowerManager.PARTIAL_WAKE_LOCK);
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);
        player.setOnPreparedListener(this);
        player.setOnCompletionListener(this);
        player.setOnErrorListener(this);
    }

    public class MusicBinder extends Binder {
        MusicService getService(){
            return MusicService.this;
        }
    }

    public void pausePlayer(){
        player.pause();
    }

    public void go(){
        if (player.isPlaying()) {
            player.stop();
        } else {
            player.start();
        }
    }

    public void playPrev(){
        songPosn--;
        songPosn = songPosn == -1 ? songs.size() - 1 : songPosn;
        callback.exactSong(songPosn);
        player.release();
        playSong();
    }

    public void playNext(){
        songPosn++;
        songPosn = songPosn == songs.size() ? 0 : songPosn;
        callback.exactSong(songPosn);
        player.release();
        playSong();
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return musicBind;
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
        Intent notIntent = new Intent(this, MainActivity.class);
        notIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendInt = PendingIntent.getActivity(this, 0,
                notIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O){
            Notification.Builder builder = new Notification.Builder(this);
            builder.setContentIntent(pendInt)
                    .setSmallIcon(R.drawable.play)
                    .setOngoing(true)
                    .setContentTitle("Title")
                    .setContentText("Notification text");
            Notification not = builder.build();
            startForeground(1, not);
        }
    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        return false;
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        mp.release();
    }

    @Override
    public boolean onUnbind(Intent intent){
        player.stop();
        player.release();
        return false;
    }
}
