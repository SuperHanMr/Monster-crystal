package com.itheima.monstercrystal.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.itheima.monstercrystal.R;
import com.itheima.monstercrystal.bean.LogdingData;
import com.itheima.monstercrystal.utils.SPUtils;
import com.zhy.autolayout.AutoLayoutActivity;

import io.rong.imkit.RongIM;

/**
 * Created by hanyonghui on 2017/6/20.
 */

public class New_PromptActivity extends AutoLayoutActivity {

    private SPUtils spUtils;
    private String string;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        spUtils = new SPUtils(New_PromptActivity.this);
        string = spUtils.getString(LogdingData.key);
        setContentView(R.layout.new_promat_ac);
        findViewById(R.id.iv_newinfo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (RongIM.getInstance() != null) {

                    if (string.equals("110")){
                        RongIM.getInstance().startPrivateChat(New_PromptActivity.this, "120", "私人聊天");
                    }else {
                        RongIM.getInstance().startPrivateChat(New_PromptActivity.this, "110", "私人聊天");
                    }
                }

            }

        });


    }
}
