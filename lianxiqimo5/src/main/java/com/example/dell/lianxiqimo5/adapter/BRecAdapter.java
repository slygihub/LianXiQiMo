package com.example.dell.lianxiqimo5.adapter;

import android.content.Context;
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

public class BRecAdapter extends RecyclerView.Adapter<BRecAdapter.ViewHolder> {
    private ArrayList<BenDao> list;
    private Context context;


    public BRecAdapter(ArrayList<BenDao> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item2, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        BenDao bean = list.get(i);
        viewHolder.collect_num.setText(bean.getCollect_num());
        viewHolder.title.setText(bean.getTitle());
        Glide.with(context).load(bean.getPic()).into(viewHolder.pic);
            viewHolder.ch.setChecked(bean.getDian());


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
