package com.example.dell.lianxiqimu2.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.dell.lianxiqimu2.R;
import com.example.dell.lianxiqimu2.bean.AndroidBean;

import java.util.ArrayList;

public class GanhuoAdapter extends RecyclerView.Adapter<GanhuoAdapter.ViewHolder> {
    private ArrayList<AndroidBean.ResultsBean> list;
    private Context context;

    public GanhuoAdapter(ArrayList<AndroidBean.ResultsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.androiditem, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AndroidBean.ResultsBean bean = list.get(position);
       // Glide.with(context).load(bean.getUrl()).into(holder.iv);
        holder.tv1.setText(bean.getDesc());
        holder.tv2.setText(bean.getType());
        holder.tv3.setText(bean.getCreatedAt());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv1;
        private TextView tv2;
        private TextView tv3;
        public ViewHolder(View itemView) {
            super(itemView);
            tv1=itemView.findViewById(R.id.tv1);
            tv2=itemView.findViewById(R.id.tv2);
            tv3=itemView.findViewById(R.id.tv3);
        }
    }
}
