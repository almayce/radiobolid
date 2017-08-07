package io.almayce.dev.radiobolid;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

/**
 * Created by almayce on 15.07.17.
 */

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private CustomPlayer64 player64;
    private CustomPlayer128 player128;

    public MainPresenter() {
        player64 = CustomPlayer64.getInstance();
        player128 = CustomPlayer128.getInstance();
        check64();
        check128();
    }

    public void play64() {
        player64.playStream();
    }

    public void play128() {
        player128.playStream();
    }

    public void stop64() {
        player64.stopStream();
    }

    public void stop128() {
        player128.stopStream();
    }

    public boolean isPlaying64() {
        return player64.isPlaying();
    }

    public boolean isPlaying128() {
        return player128.isPlaying();
    }

    public void check64() {
        Observable.interval(1, TimeUnit.MILLISECONDS)
                .compose(new SchedulersTransformer<>())
                .subscribe(aLong -> {
                    if (aLong % 500 == 0) {
                        if (player64.getReady()) {
                            getViewState().enableButton64();
                        } else getViewState().disableButton64();

                        if (player64.isPlaying())
                            getViewState().showStopButton64();
                        else getViewState().showPlayButton64();
                    }
                });
    }

    public void check128() {
        Observable.interval(1, TimeUnit.MILLISECONDS)
                .compose(new SchedulersTransformer<>())
                .subscribe(aLong -> {
                    if (aLong % 500 == 0) {
                        if (player128.getReady()) {
                            getViewState().enableButton128();
                        } else getViewState().disableButton128();

                        if (player128.isPlaying())
                            getViewState().showStopButton128();
                        else getViewState().showPlayButton128();
                    }
                });
    }
}
