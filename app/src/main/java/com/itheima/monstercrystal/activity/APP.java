package com.itheima.monstercrystal.activity;

import android.app.Application;

import io.rong.imkit.RongIM;

/**
 * Created by hanyonghui on 2017/6/9.
 */

public class APP extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        RongIM.init(this);
    }
}
