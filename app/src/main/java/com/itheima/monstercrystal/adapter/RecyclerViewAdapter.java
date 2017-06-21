package com.itheima.monstercrystal.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.itheima.monstercrystal.R;
import com.itheima.monstercrystal.bean.LogdingData;
import com.itheima.monstercrystal.utils.SPUtils;


import io.rong.imkit.RongIM;


/**
 * Created by hanyonghui on 2017/6/3.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHodler> {

    private Context context;

    private final int TYPE_LN = 1;

    private final int TYPE_THE = 2;

    private boolean isSelector;
    private int item;


    String[] name = {"范玮琪", "张灵颖", "张百川", "李秀秀", "高得伟"};
    String[] info = {"吃饭去吗", "回家看电影", "我还在上班", "哈哈哈哈", "不太清楚"};
    private int selectedPosition = -1;

    public RecyclerViewAdapter(Context context) {
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
        MyViewHodler hodler = new MyViewHodler(LayoutInflater.from(context).inflate(R.layout.item_recyclerview, parent, false));

        return hodler;
    }

    @Override
    public void onBindViewHolder(final MyViewHodler holder, final int position) {


        //holder.imageView.setImageResource(touxiang[position]); 设置头像
        holder.tvName.setText("测试");
        holder.tvInfo.setText("测试");


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            // 跳转到信息页面

            public void onClick(View v) {
                // TODO：在这个位置 我要调整当前item的Background
//                holder.itemView.setBackgroundResource(R.drawable.ln_crease);

//                for (int i = 0; i < 30; i++) {
//                    selectedPosition = i;
//                    Log.e("1111111111111111", "" + selectedPosition);
//
////                        notifyItemChanged(i);
//                    if (selectedPosition == position) {
//                        ///holder.itemView.setBackgroundResource(R.drawable.item_background_the);
//                        v.setBackgroundResource(R.drawable.ln_crease);
//                        Log.e("222", "" + selectedPosition + "++++++++++++++++" + position);
//
//                    } else if ((position + 1) == selectedPosition) {
//                        ///holder.itemView.setBackgroundResource(R.drawable.item_background_the);
//                        v.setBackgroundResource(R.drawable.the_crease);
//                        Log.e("222", "" + selectedPosition + "++++++++++++++++" + position);
//
//                    } else {
//                        v.setBackgroundResource(R.color.transparent);
//                        Log.e("333333333333333", "" + selectedPosition + "++++++++++++++++" + position);
//                    }
//
//                }
                if (onListitem != null){
                    onListitem.item(position);
                }

                notifyDataSetChanged();


                SPUtils spUtils = new SPUtils(context);
                if (RongIM.getInstance() != null) {
                    String string = spUtils.getString(LogdingData.key);
                    if (string.equals("110")){
                        RongIM.getInstance().startPrivateChat(context, "120", "私人聊天");
                    }else {
                        RongIM.getInstance().startPrivateChat(context, "110", "私人聊天");
                    }
                }

            }
        });
    }


    //------------------------------
    private OnListitem onListitem;

    public interface OnListitem{
        void item (int position);
    }

    public void setOnListitem(OnListitem onListitem){
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
        private final TextView tvInfo;
        private final LinearLayout ll;
        private final View fen;


        public MyViewHodler(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv_portrait);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvInfo = (TextView) itemView.findViewById(R.id.tv_info);
            ll = (LinearLayout) itemView.findViewById(R.id.item_ll);
            fen = itemView.findViewById(R.id.item_fen);

        }

    }//
}
