package com.itheima.monstercrystal.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.itheima.monstercrystal.R;
import com.itheima.monstercrystal.fragment.CircleFragment;
import com.itheima.monstercrystal.fragment.ContactFragmnet;
import com.itheima.monstercrystal.fragment.Fragment_info;

/**
 * Created by hanyonghui on 2017/6/10.
 */

public class SessionList extends FragmentActivity {

    private boolean is = true;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sessionlist_activity);
        setDefaultFragment();
        initView();
    }

    private void initView() {
        findViewById(R.id.iv_qan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SessionList.this,CirleActivity.class));
            }
        });
        findViewById(R.id.iv_ren).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SessionList.this,ContactActivity.class));
            }
        });
        findViewById(R.id.iv_info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (is){

                    startActivity(new Intent(SessionList.this,PromptActivity.class));
                    is = false;
                }else {
                    startActivity(new Intent(SessionList.this,New_PromptActivity.class));
                    is = true;
                }


            }
        });
    }
    // 设置Fragment
    private void setDefaultFragment() {
        FragmentManager sFm = getSupportFragmentManager();
        FragmentTransaction ft = sFm.beginTransaction();
        ft.replace(R.id.fragment,new Fragment_info());
        ft.commit();
    }
}
