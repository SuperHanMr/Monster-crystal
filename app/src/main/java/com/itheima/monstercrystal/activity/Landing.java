package com.itheima.monstercrystal.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;

import com.itheima.monstercrystal.R;
import com.itheima.monstercrystal.bean.LogdingData;
import com.itheima.monstercrystal.utils.SPUtils;
import com.itheima.monstercrystal.views.WeiboDialogUtils;
import com.zhy.autolayout.AutoLayoutActivity;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;

/**
 * Created by hanyonghui on 2017/6/9.
 */

public class Landing extends AutoLayoutActivity implements View.OnClickListener {

    private Dialog mWeiboDialog;

    private EditText edPwa;
    // ID为110
    private String token = "leT2O3DAtvd3zA8yJ+wFOD7mLb4MFuWtZHWX5OKkT9BWuBRh9UX56mBjGT8vO13x9kxAAYVh8OV3jW10tAPo5g==";
    // ID为120
    private String  token2 = "XSzPUWxtNmU39c2f+rWKWQKWiGZecOlxMR9mKsYUo52opHfUFE7CxsLpXnkISFM9dnJrscRP0g+ifmaMzfKkPw==";
    private SPUtils spUtils;

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
        setContentView(R.layout.loding);
        initView();
    }

    // 找到控件
    private void initView() {
        spUtils = new SPUtils(this);
        edPwa = (EditText) findViewById(R.id.ed_pwa);
        ImageView imageView = (ImageView) findViewById(R.id.logding);
        imageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
      String  trim = edPwa.getText().toString().trim();
        switch (trim){
            case "110":
                // 密码输入110进入用户一
                connectRongServer(token);
                break;
            case "120":
                // 密码输入120 进入用户二
                connectRongServer(token2);
                break;
        }

    }

    //再这里联网登陆融云
     private void connectRongServer(String token) {
         RongIM.connect(token, new RongIMClient.ConnectCallback() {

             // token过期或者无效返回的回调
             @Override
             public void onTokenIncorrect() {

             }


             // 成功返回的tokenID
             @Override
             public void onSuccess(String s) {
                 if (s.equals("110")){
                     spUtils.putString(LogdingData.key,"110");
                     mWeiboDialog = WeiboDialogUtils.createLoadingDialog(Landing.this, "加载中...");
                     startActivity(new Intent(Landing.this,SessionList.class));
                     finish();
                 }else {
                     spUtils.putString(LogdingData.key,"120");
                     mWeiboDialog = WeiboDialogUtils.createLoadingDialog(Landing.this, "加载中...");
                     startActivity(new Intent(Landing.this,SessionList.class));
                     finish();
                 }

             }

             // 连接不上融云服服务器会返回对应的错误码 详情查看官网
             @Override
             public void onError(RongIMClient.ErrorCode errorCode) {

             }
         });
    }
}
