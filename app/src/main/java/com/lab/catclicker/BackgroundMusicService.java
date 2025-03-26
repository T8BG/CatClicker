package com.lab.catclicker;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class BackgroundMusicService extends Service {

    MediaPlayer music;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startID)
    {
        music = MediaPlayer.create(this, R.raw.bgm);
        music.start();
        return super.onStartCommand(intent, flags, startID);
    }

    @Override
    public boolean stopService(Intent intent)
    {
        return super.stopService(intent);
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        music.stop();
        music.release();
    }

}
