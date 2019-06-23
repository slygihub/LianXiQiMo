package com.example.dell.lianxiqimu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.lianxiqimu.Ben.Ben;
import com.example.dell.lianxiqimu.R;

import java.util.ArrayList;

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.ViewHolder> {
    private ArrayList<Ben.DataBean.ListBean>list;
    private Context context;

    public RecAdapter(ArrayList<Ben.DataBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public interface User{
        void oncli(View view,int position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Ben.DataBean.ListBean bean = list.get(i);
        viewHolder.name.setText(bean.getName());
        viewHolder.sellCount.setText(bean.getSellCount()+"");
        viewHolder.stockCount.setText(bean.getStockCount()+"");
        Glide.with(context).load(bean.getPic()).into(viewHolder.pic);

        
    }



    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView pic;
        private final TextView stockCount;
        private final TextView sellCount;
        private final TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pic = itemView.findViewById(R.id.pic);
            name = itemView.findViewById(R.id.name);
            sellCount = itemView.findViewById(R.id.sellCount);
            stockCount = itemView.findViewById(R.id.stockCount);
        }
    }
}
