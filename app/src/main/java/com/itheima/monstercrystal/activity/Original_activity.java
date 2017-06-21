package com.itheima.monstercrystal.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.itheima.monstercrystal.R;
import com.zhy.autolayout.AutoLayoutActivity;

/**
 * Created by hanyonghui on 2017/6/19.
 */

public class Original_activity extends AutoLayoutActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.larger_activity);

    }
}
