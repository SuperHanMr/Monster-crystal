package com.itheima.monstercrystal.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.itheima.monstercrystal.R;
import com.zhy.autolayout.AutoLayoutActivity;

/**
 * Created by hanyonghui on 2017/6/19.
 */

public class CirleActivity extends AutoLayoutActivity {

    private RelativeLayout turf;
    private ImageView imageView;
    private int count;
    private int num;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
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
        setContentView(R.layout.friends);
        turf = (RelativeLayout) findViewById(R.id.turf);
        imageView = (ImageView) findViewById(R.id.iv_selected);
        //*-----------------------------设置动画分割线---------------------------------------
        turf.startAnimation(getAnimation());// 起始动画 从小到大
        turf.setOnClickListener(new View.OnClickListener() {// 点击 旋转效果
            @Override
            public void onClick(View v) {
                // 在这里设置旋转动画
                turf.startAnimation(getRotate());

            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count==1){
                    // 变大
                    // Toast.makeText(getContext(), "变大", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(CirleActivity.this, Original_activity.class));
                    count = 0;
                    num++;
                    return;
                }
                if (num==2){
                    num=0;
                    imageView.startAnimation(getXAnimation());
                    return;

                }
                num++;
                count++;
                imageView.startAnimation(getYAnimation());
            }
        });

    }
    protected Animation getAnimation() {
        Animation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);// 从0.5倍放大到1倍
        anim.setDuration(1500);
        return anim;
    }
    // 旋转动画
    protected Animation getRotate(){
        RotateAnimation animation = new RotateAnimation(0f,360f,Animation.RELATIVE_TO_SELF,
                0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        animation.setDuration(3000);
        animation.setFillAfter(true);//设置动画结束后停留在该位置
        return animation;
    }

    // 点击图片执行向上平移动画
    protected Animation getYAnimation(){
        TranslateAnimation animation = new TranslateAnimation(0, 0,-30, -30);
        animation.setDuration(100);//设置动画持续时间
        animation.setFillAfter(true);//设置动画结束后停留在该位置
        return animation;
    }
    // 点击图片执行向下平移动画
    protected Animation getXAnimation(){
        TranslateAnimation animation = new TranslateAnimation(0, 0,0, 0);
        animation.setDuration(100);//设置动画持续时间
        animation.setFillAfter(true);//设置动画结束后停留在该位置
        return animation;
    }
}

