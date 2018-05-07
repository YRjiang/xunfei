package com.newland.emergencybroadcast;

import android.app.Application;

import com.iflytek.cloud.SpeechUtility;

/**
 * Created by Administrator on 2018-4-18.
 */

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SpeechUtility.createUtility(getApplicationContext(), "appid=5ad7034d ");
        AudioUtils.getInstance().init(getApplicationContext());
    }

}
