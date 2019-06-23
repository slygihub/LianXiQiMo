package com.example.dell.lianxiqimo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.lianxiqimo.R;
import com.example.dell.lianxiqimo.ben.Bean;

import java.util.ArrayList;

public class ARecAdapter extends RecyclerView.Adapter<ARecAdapter.ViewHolder> {
    private ArrayList<Bean.DataBean>list;
    private Context context;

    public ARecAdapter(ArrayList<Bean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Bean.DataBean bean = list.get(i);
        viewHolder.collect_num.setText(bean.getCollect_num());
        viewHolder.title.setText(bean.getTitle());
        Glide.with(context).load(bean.getPic()).into(viewHolder.pic);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView pic;
        private final TextView title;
        private final TextView collect_num;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pic = itemView.findViewById(R.id.pic);
            title = itemView.findViewById(R.id.title);
            collect_num = itemView.findViewById(R.id.collect_num);

        }
    }
}
