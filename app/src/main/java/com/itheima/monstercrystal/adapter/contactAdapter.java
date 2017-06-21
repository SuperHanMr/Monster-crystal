package com.itheima.monstercrystal.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.itheima.monstercrystal.R;

/**
 * Created by hanyonghui on 2017/6/18.
 */

public class contactAdapter extends RecyclerView.Adapter<contactAdapter.Myhodler> {

    private Context context;

    public contactAdapter(Context context) {
        this.context = context;

    }
    @Override
    public Myhodler onCreateViewHolder(ViewGroup parent, int viewType) {
        Myhodler hodler = new Myhodler(LayoutInflater.from(context).inflate(R.layout.item_contact_recyclerview, parent, false));

        return hodler;
    }

    @Override
    public void onBindViewHolder(Myhodler holder, final int position) {
        //holder.imageView.setImageDrawable("头像");
        holder.tvName.setText("测试");
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
                if (onitemRecycler != null){
                    onitemRecycler.item(position);
                }

                notifyDataSetChanged();




            }
        });
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    private OnitemRecycler onitemRecycler;

    public interface OnitemRecycler{
        void item (int position);
    }

    public void getViewPointion(OnitemRecycler onitemRecycler){
        this.onitemRecycler = onitemRecycler;
    }

    public class Myhodler extends RecyclerView.ViewHolder{

        private final ImageView imageView;
        private final TextView tvName;

        public Myhodler(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv_contact_portrait);
            tvName = (TextView) itemView.findViewById(R.id.tv_contact_name);
        }
    }


}
