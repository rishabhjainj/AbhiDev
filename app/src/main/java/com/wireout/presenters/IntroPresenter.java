package com.wireout.presenters;


import com.wireout.common.PrefManager;
import com.wireout.view.IntroNavigator;

public class IntroPresenter {

    private IntroNavigator introNavigator;

    public IntroPresenter(IntroNavigator introNavigator){
        this.introNavigator = introNavigator;
    }

    public void start(PrefManager prefManager) {

        if(prefManager.isFirstTimeLaunch()){
            prefManager.setFirstTimeLaunch(false);
            introNavigator.startPreferencesActivity();
        }else{
            introNavigator.startMainActivity();
        }
    }
}
