package io.almayce.dev.radiobolid;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by almayce on 15.07.17.
 */
@StateStrategyType(AddToEndSingleStrategy.class)
public interface MainView  extends MvpView{
    void enableButton64();
    void enableButton128();
    void disableButton64();
    void disableButton128();
    void showStopButton64();
    void showStopButton128();
    void showPlayButton64();
    void showPlayButton128();
}
