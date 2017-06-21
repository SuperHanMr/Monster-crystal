package com.itheima.monstercrystal.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.EventLog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.itheima.monstercrystal.R;

import static android.support.v7.widget.StaggeredGridLayoutManager.TAG;

/**
 * Created by hanyonghui on 2017/6/12.
 */

public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private final int TYPE_LN = 1;
    private final int TYPE_THE = 2;
    private Context context;




    public ItemAdapter (Context context){
        this.context = context;
    }

    // 为多条目做判断
    @Override
    public int getItemViewType(int position) {
        if (position%2==0){
            return TYPE_LN;
        }else {
            return TYPE_THE;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;

        if (viewType==TYPE_LN){

            view =  LayoutInflater.from(context).inflate(R.layout.item_recyclerview,parent,false);
            return new MyViewHodler(view);
        }else if (viewType==TYPE_THE){
            view= LayoutInflater.from(context).inflate(R.layout.item_recyclerview_the,parent,false);
            return new TheHodler(view);
        }
        return null;
    }



    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {

        int itemViewType = getItemViewType(position);
        if (itemViewType == TYPE_LN){

            final MyViewHodler myViewHodler = (MyViewHodler) holder;

            myViewHodler.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  holder.itemView.setBackgroundResource(R.drawable.ln_crease);

                    Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
                }
            });
        }else if(itemViewType==TYPE_THE){
           holder.itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   holder.itemView.setBackgroundResource(R.drawable.the_crease);
               }
           });
        }
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class MyViewHodler extends RecyclerView.ViewHolder{
        private LinearLayout ll;
        private final ImageView imageView;
        private final TextView tvName;
        private final TextView tvInfo;

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



    public class TheHodler extends RecyclerView.ViewHolder{

        private final ImageView imageView;
        private final TextView tvName;
        private final TextView tvInfo;
        private LinearLayout ll_the;
        private final View fen;


        public TheHodler(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv_portrait);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvInfo = (TextView) itemView.findViewById(R.id.tv_info);
            ll_the = (LinearLayout) itemView.findViewById(R.id.item_ll);
            fen = itemView.findViewById(R.id.item_fen);

        }

    }//
}
