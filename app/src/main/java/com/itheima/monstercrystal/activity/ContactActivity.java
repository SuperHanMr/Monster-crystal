package com.itheima.monstercrystal.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.itheima.monstercrystal.R;
import com.itheima.monstercrystal.adapter.RecyclerViewAdapter_contact;
import com.itheima.monstercrystal.adapter.contactAdapter;
import com.zhy.autolayout.AutoLayoutActivity;

/**
 * Created by hanyonghui on 2017/6/19.
 */

public class ContactActivity extends AutoLayoutActivity {
    private LinearLayoutManager layoutManager;
    private int seletor;
    private RecyclerView recyclerView1;
    private RecyclerViewAdapter_contact adapter_contact;
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
        setContentView(R.layout.contact);
        recyclerView1 = (RecyclerView)findViewById(R.id.contact_recycler);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView1.setLayoutManager(layoutManager);
        adapter_contact = new RecyclerViewAdapter_contact(this);
        recyclerView1.setAdapter(adapter_contact);
        adapter_contact.setOnListitem(new RecyclerViewAdapter_contact.OnListitem1() {
            @Override
            public void item(int position) {

                if (position==seletor){
                    View childAt = layoutManager.getChildAt(position);
                    View childAt1 = layoutManager.getChildAt(position+1);
                    childAt.setBackgroundResource(R.drawable.ln_crease);
                    childAt1.setBackgroundResource(R.drawable.the_crease);
                    seletor = position;
                    Log.e("000000000000", "item: 走没走"+seletor);
                }else if (position==seletor +1){
                    View childAt = layoutManager.getChildAt(position-1);
                    childAt.setBackgroundResource(R.color.transparent);

                    View childAt2 = layoutManager.getChildAt(position);
                    childAt2.setBackgroundResource(R.drawable.ln_crease);

                    View childAt1 = layoutManager.getChildAt(position+1);
                    childAt1.setBackgroundResource(R.drawable.the_crease);


                    seletor = position;
                }else {
                    Log.e("000000000000", "item: 走没走");

                    View childAt = layoutManager.getChildAt(position);
                    View childAt1 = layoutManager.getChildAt(position+1);
                    childAt.setBackgroundResource(R.drawable.ln_crease);
                    childAt1.setBackgroundResource(R.drawable.the_crease);

                    View childAt2 = layoutManager.getChildAt(seletor);
                    View childAt3 = layoutManager.getChildAt(seletor+1);
                    childAt2.setBackgroundResource(R.color.transparent);
                    childAt3.setBackgroundResource(R.color.transparent);
                    seletor = position;
                }

                adapter_contact.notifyDataSetChanged();
            }

        });
    }

}
