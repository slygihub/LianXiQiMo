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
import com.example.dell.lianxiqimu2.bean.WeChatBean;


import java.util.ArrayList;

public class WeChatAdapter extends RecyclerView.Adapter<WeChatAdapter.ViewHolder> {
    private ArrayList<WeChatBean.NewslistBean> list;
    private Context context;

    public WeChatAdapter(ArrayList<WeChatBean.NewslistBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.wechatitem, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        WeChatBean.NewslistBean bean = list.get(position);
        Glide.with(context).load(bean.getPicUrl()).into(holder.iv);
        holder.tv1.setText(bean.getTitle());
        holder.tv2.setText(bean.getDescription());
        holder.tv3.setText(bean.getCtime());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView tv1;
        private TextView tv2;
        private TextView tv3;
        public ViewHolder(View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv);
            tv1=itemView.findViewById(R.id.tv1);
            tv2=itemView.findViewById(R.id.tv2);
            tv3=itemView.findViewById(R.id.tv3);

        }
    }
}
