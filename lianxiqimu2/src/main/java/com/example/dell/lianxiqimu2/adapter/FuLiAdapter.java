package com.example.dell.lianxiqimu2.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.dell.lianxiqimu2.R;
import com.example.dell.lianxiqimu2.bean.FuLiBean;


import java.util.ArrayList;

public class FuLiAdapter extends RecyclerView.Adapter<FuLiAdapter.ViewHolder> {
    private ArrayList<FuLiBean.ResultsBean> list;
    private Context context;

    public FuLiAdapter(ArrayList<FuLiBean.ResultsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.fuliitem, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FuLiBean.ResultsBean bean = list.get(position);
       Glide.with(context).load(bean.getUrl()).into(holder.iv);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;

        public ViewHolder(View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv);
        }
    }
}
