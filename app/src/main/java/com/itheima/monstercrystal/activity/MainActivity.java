package com.itheima.monstercrystal.activity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.itheima.monstercrystal.R;
import com.zhy.autolayout.AutoLayoutActivity;

public class MainActivity extends AutoLayoutActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.splash_activity);
        initView();
    }

    private void initView() {
        ImageView iv = (ImageView) findViewById(R.id.iv_smoke);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(iv, "translationX", 500f, 0f);
        ObjectAnimator animator = ObjectAnimator.ofFloat(iv, "alpha", 0f, 1.0f);
        animator.ofFloat(iv, "alpha", 1f, 0f, 1f);
        animator2.setDuration(4000);
        animator2.start();
        animator.setDuration(6000);
        animator.start();

        thread();
    }

    private void thread() {
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    sleep(4000);
                    startActivity(new Intent(MainActivity.this,Landing.class));
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
