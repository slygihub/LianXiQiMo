package com.example.dell.lianxiqimo5.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.lianxiqimo5.R;
import com.example.dell.lianxiqimo5.app.BenDao;
import com.example.dell.lianxiqimo5.app.Gong;
import com.example.dell.lianxiqimo5.ben.Bean;

import java.util.ArrayList;
import java.util.Map;

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.ViewHolder> {
    private ArrayList<Bean.DataBean> list;
    private Context context;
    public boolean isch;

    //手写的set方法
    public RecAdapter setIscheck(boolean ch) {
        isch = ch;
        return this;
    }

    public RecAdapter(ArrayList<Bean.DataBean> list, Context context) {
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
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        Bean.DataBean bean = list.get(i);
        viewHolder.collect_num.setText(bean.getCollect_num());
        viewHolder.title.setText(bean.getTitle());
        Glide.with(context).load(bean.getPic()).into(viewHolder.pic);
        viewHolder.ch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    Bean.DataBean bean1 = list.get(i);
                    BenDao dao = new BenDao();
                    dao.setTitle(bean1.getTitle());
                    dao.setPic(bean1.getPic());
                    dao.setCollect_num(bean1.getCollect_num());
                    dao.setId(Long.valueOf(i));
                    dao.setDian(b);
                    Gong.getGong().insert(dao);
                }
            }
        });
        if (isch) {
            viewHolder.ch.setVisibility(View.VISIBLE);
        } else {
            viewHolder.ch.setVisibility(View.GONE);
        }


    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView pic;
        private final TextView title;
        private final TextView collect_num;
        private CheckBox ch;
        View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pic = itemView.findViewById(R.id.pic);
            title = itemView.findViewById(R.id.title);
            collect_num = itemView.findViewById(R.id.collect_num);
            ch = itemView.findViewById(R.id.ch);
            view = itemView;
        }
    }
}
