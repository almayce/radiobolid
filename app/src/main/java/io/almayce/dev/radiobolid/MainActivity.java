package io.almayce.dev.radiobolid;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import io.almayce.dev.radiobolid.databinding.ActivityMainBinding;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    @InjectPresenter
    MainPresenter mainPresenter;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    @Override
    public void enableButton64() {
        binding.playStop64.setEnabled(true);
    }

    @Override
    public void disableButton64() {
        binding.playStop64.setEnabled(false);

    }

    @Override
    public void showStopButton64() {
        binding.playStop64.setImageResource(R.drawable.ic_stop_black_24dp);
    }

    @Override
    public void showPlayButton64() {
        binding.playStop64.setImageResource(R.drawable.ic_play_arrow_black_24dp);

    }

    @Override
    public void enableButton128() {
        binding.playStop128.setEnabled(true);
    }

    @Override
    public void disableButton128() {
        binding.playStop128.setEnabled(false);

    }

    @Override
    public void showStopButton128() {
        binding.playStop128.setImageResource(R.drawable.ic_stop_black_24dp);
    }

    @Override
    public void showPlayButton128() {
        binding.playStop128.setImageResource(R.drawable.ic_play_arrow_black_24dp);

    }

    public void onPlayStopClick64(View view) {
        mainPresenter.stop128();
        if (mainPresenter.isPlaying64())
            mainPresenter.stop64();
        else
            mainPresenter.play64();

    }

    public void onPlayStopClick128(View view) {
        mainPresenter.stop64();
        if (mainPresenter.isPlaying128())
            mainPresenter.stop128();
        else
            mainPresenter.play128();

    }
}
