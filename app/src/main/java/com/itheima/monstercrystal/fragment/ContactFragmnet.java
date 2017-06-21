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
import com.itheima.monstercrystal.adapter.RecyclerViewAdapter;
import com.itheima.monstercrystal.adapter.RecyclerViewAdapter_contact;
import com.itheima.monstercrystal.adapter.contactAdapter;


/**
 * Created by hanyonghui on 2017/6/18.
 */

public class ContactFragmnet extends Fragment {
    private LinearLayoutManager layoutManager;
    private contactAdapter contactAdapter;
    private int seletor;
    private RecyclerView recyclerView1;
    private RecyclerViewAdapter_contact adapter_contact;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contact,container,false);
        recyclerView1 = (RecyclerView) view.findViewById(R.id.contact_recycler);
        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView1.setLayoutManager(layoutManager);
        adapter_contact = new RecyclerViewAdapter_contact(getContext());
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
       return view;
    }
}
