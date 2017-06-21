package com.itheima.monstercrystal.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.itheima.monstercrystal.R;
import com.itheima.monstercrystal.utils.SPUtils;


/**
 * Created by hanyonghui on 2017/6/3.
 */

public class RecyclerViewAdapter_contact extends RecyclerView.Adapter<RecyclerViewAdapter_contact.MyViewHodler> {

    private Context context;

    private final int TYPE_LN = 1;

    private final int TYPE_THE = 2;

    private boolean isSelector;
    private int item;


    String[] name = {"范玮琪", "张灵颖", "张百川", "李秀秀", "高得伟"};
    String[] info = {"吃饭去吗", "回家看电影", "我还在上班", "哈哈哈哈", "不太清楚"};
    private int selectedPosition = -1;

    public RecyclerViewAdapter_contact(Context context) {
        this.context = context;

    }
    // 多种条目

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return TYPE_LN;
        } else {
            return TYPE_THE;
        }
    }

    @Override
    public MyViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHodler hodler = new MyViewHodler(LayoutInflater.from(context).inflate(R.layout.item_recyclerview_contact, parent, false));

        return hodler;
    }

    @Override
    public void onBindViewHolder(final MyViewHodler holder, final int position) {


        holder.tvName.setText("测试");


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            // 跳转到信息页面

            public void onClick(View v) {
                // TODO：在这个位置 我要调整当前item的Background
                if (onListitem != null){
                    onListitem.item(position);
                }

                notifyDataSetChanged();
            }
        });
    }


    //------------------------------
    private OnListitem1 onListitem;

    public interface OnListitem1{
        void item(int position);
    }

    public void setOnListitem(OnListitem1 onListitem){
       this.onListitem = onListitem;
    }




    @Override
    public int getItemCount() {
        return 8;
    }

    /*
   ;
     */

    public class MyViewHodler extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView tvName;
        private final LinearLayout ll;
        private final View fen;


        public MyViewHodler(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv_portrait);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            ll = (LinearLayout) itemView.findViewById(R.id.item_ll);
            fen = itemView.findViewById(R.id.item_fen);

        }

    }//
}
