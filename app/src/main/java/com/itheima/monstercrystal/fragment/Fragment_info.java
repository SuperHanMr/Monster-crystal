package com.itheima.monstercrystal.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itheima.monstercrystal.R;
import com.itheima.monstercrystal.adapter.ItemAdapter;
import com.itheima.monstercrystal.adapter.RecyclerViewAdapter;

/**
 * Created by hanyonghui on 2017/6/3.
 * 
 */

public class Fragment_info extends Fragment {

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private RecyclerViewAdapter recyclerViewAdapter;
    private int seletor;

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
        recyclerViewAdapter = new RecyclerViewAdapter(getContext());

        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.setOnListitem(new RecyclerViewAdapter.OnListitem() {
            @Override
            public void item(int position) {
//                Toast.makeText(getContext(), "fhhfh", Toast.LENGTH_SHORT).show();

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

                recyclerViewAdapter.notifyDataSetChanged();
            }
        });
        return view;
    }


}
