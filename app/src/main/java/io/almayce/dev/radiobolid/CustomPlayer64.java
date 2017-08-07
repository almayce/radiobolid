package io.almayce.dev.radiobolid;

import android.media.AudioManager;
import android.media.MediaPlayer;

import java.io.IOException;

/**
 * Created by almayce on 15.07.17.
 */

public class CustomPlayer64 {
    private final static CustomPlayer64 instance = new CustomPlayer64();
    public static CustomPlayer64 getInstance() {
        return instance;
    }

    private final static String stream = "http://eu4.radioboss.fm:8184/stream";
    private MediaPlayer mediaPlayer;
    private boolean ready = false;

    private CustomPlayer64() {
        if (mediaPlayer == null)
            init();
    }

    public void init() {
        ready = false;
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer.prepareAsync();
        mediaPlayer.setOnPreparedListener(mp -> {
            mediaPlayer.start();
            ready = true;
        });
    }

    public void playStream() {
        mediaPlayer.start();
    }

    public void stopStream() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    public boolean isPlaying() {
        return mediaPlayer.isPlaying();
    }

    public boolean getReady() {
        return ready;
    }
}
