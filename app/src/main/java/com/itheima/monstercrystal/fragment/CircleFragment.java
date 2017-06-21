package com.itheima.monstercrystal.fragment;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.itheima.monstercrystal.R;
import com.itheima.monstercrystal.activity.Original_activity;

/**
 * Created by hanyonghui on 2017/6/19.
 */

public class CircleFragment extends Fragment {

    private RelativeLayout turf;
    private ImageView imageView;
    private int count;
    private int num;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.friends,container,false);
        turf = (RelativeLayout) view.findViewById(R.id.turf);
        imageView = (ImageView) view.findViewById(R.id.iv_selected);
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
                    startActivity(new Intent(getContext(), Original_activity.class));
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

        return view;
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
