package com.example.dell.lianxiqimu2.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.lianxiqimu2.R;
import com.example.dell.lianxiqimu2.bean.ReMenBean;


import java.util.ArrayList;

public class ReMenAdapter extends RecyclerView.Adapter<ReMenAdapter.ViewHolder> {
    private ArrayList<ReMenBean.RecentBean> list;
    private Context context;

    public ReMenAdapter(ArrayList<ReMenBean.RecentBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.ribaoitem3, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(list.get(position).getThumbnail()).into(holder.iv);
        holder.tv1.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView tv1;
        public ViewHolder(View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv);
            tv1=itemView.findViewById(R.id.tv1);
        }
    }
}
