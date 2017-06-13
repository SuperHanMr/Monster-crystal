package com.itheima.monstercrystal.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.itheima.monstercrystal.R;
import com.itheima.monstercrystal.adapter.ItemAdapter;
import com.itheima.monstercrystal.adapter.RecyclerViewAdapter;

/**
 * Created by hanyonghui on 2017/6/3.
 */

public class Fragment_info extends Fragment {

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info,container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        layoutManager = new LinearLayoutManager(getContext());
        //设置布局管理器
        recyclerView.setLayoutManager(layoutManager);
        //设置为垂直布局，这也是默认的
        layoutManager.setOrientation(OrientationHelper. VERTICAL);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext());
        ItemAdapter itemAdapter = new ItemAdapter(getContext());
        //recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setAdapter(itemAdapter);
        return view;
    }


}
