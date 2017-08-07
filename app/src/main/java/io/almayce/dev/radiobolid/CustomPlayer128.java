package io.almayce.dev.radiobolid;

import android.media.AudioManager;
import android.media.MediaPlayer;

import java.io.IOException;

/**
 * Created by almayce on 15.07.17.
 */

public class CustomPlayer128 {
    private final static CustomPlayer128 instance = new CustomPlayer128();
    public static CustomPlayer128 getInstance() {
        return instance;
    }
    private final static String stream = "http://eu4.radioboss.fm:8181/stream";
    private MediaPlayer mediaPlayer;
    private boolean ready = false;

    private CustomPlayer128() {
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
