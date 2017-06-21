package com.itheima.monstercrystal.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

public class RecyclerViewAdapter_change extends RecyclerView.Adapter<RecyclerViewAdapter_change.MyViewHodler> {

    private Context context;

    private final int TYPE_LN = 1;

    private final int TYPE_THE = 2;

    private boolean isSelector;
    private int item;


    String[] name = {"范玮琪", "张灵颖", "张百川", "李秀秀", "高得伟"};
    String[] info = {"吃饭去吗", "回家看电影", "我还在上班", "哈哈哈哈", "不太清楚"};
    private int selectedPosition;

    public RecyclerViewAdapter_change(Context context) {
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
        holder.itemView.setBackgroundResource(R.color.transparent);


//        if ((selectedPosition + 1) == position) {
//            ///holder.itemView.setBackgroundResource(R.drawable.item_background_the);
//            holder.itemView.setBackgroundResource(R.drawable.the_crease);
//
//        } else
//

        if ((selectedPosition - 2) == position) {
            Log.e("111111111", position + "+++++++++++++++++++++++++=" + selectedPosition);
            holder.itemView.setBackgroundResource(R.color.transparent);
        } else if ((selectedPosition - 1) == position) {
            holder.itemView.setBackgroundResource(R.color.transparent);
        } else if (selectedPosition == position) {
            holder.itemView.setBackgroundResource(R.drawable.ln_crease);
        } else if ((selectedPosition + 1) == position) {
            holder.itemView.setBackgroundResource(R.drawable.the_crease);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            // 跳转到信息页面

            public void onClick(View v) {
                // TODO：在这个位置 我要调整当前item的Background
                holder.itemView.setBackgroundResource(R.drawable.ln_crease);

                selectedPosition = position;
//                notifyItemChanged(position + 1);// 刷新下一个条目


                if (position != 0 && position != 1) {
                    for (int i = 0; i < 4; i++) {
                        notifyItemChanged(position + i - 2);// 刷新下一个条目
                        Log.e("111111111", position + i - 2 + "____________________" + selectedPosition);
                    }
                }


                SPUtils spUtils = new SPUtils(context);
                // 发起聊天页面
//                if (RongIM.getInstance() != null) {
//                    String string = spUtils.getString(LogdingData.key);
//                    if (string.equals("110")){
//                        RongIM.getInstance().startPrivateChat(context, "120", "私人聊天");
//                    }else {
//                        RongIM.getInstance().startPrivateChat(context, "110", "私人聊天");
//                    }
//                }

            }
        });
    }


//    private OnListitem onListitem;
//
//    public interface OnListitem{
//        void item (int poston);
//    }
//
//    private void setItem(int po){
//        onListitem.item(po);
//
//    }

    @Override
    public int getItemCount() {
        return 30;
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
