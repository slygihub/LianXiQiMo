package com.example.dell.lianxiqimo4.adapter;

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
import com.example.dell.lianxiqimo4.Ben;
import com.example.dell.lianxiqimo4.R;
import com.example.dell.lianxiqimo4.contract.Contract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.http.POST;

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.ViewHolder> {
    private ArrayList<Ben.DataBean> list;
    private Context context;
    public boolean isch;
    //错乱1
    private Map<Integer,Boolean> map=new HashMap<>();

    //手写的set方法
    public RecAdapter setIscheck(boolean ch) {
        isch = ch;
        return this;

    }



    public RecAdapter(ArrayList<Ben.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
        //错乱2
        initmap();
    }
    //错乱3
    private void initmap() {
        for (int i = 0; i < list.size(); i++) {
            map.put(i,true);
        }
    }

    private Jie jie;

    public void setJie(Jie jie) {
        this.jie = jie;
    }

    public interface Jie {
        void hui(ViewHolder viewHolder, int i);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        Ben.DataBean bean = list.get(i);
        viewHolder.collect_num.setText(bean.getCollect_num());
        viewHolder.title.setText(bean.getTitle());
        Glide.with(context).load(bean.getPic()).into(viewHolder.pic);

        if (isch) {
            viewHolder.ch.setVisibility(View.VISIBLE);
        } else {
            viewHolder.ch.setVisibility(View.GONE);
        }

        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                jie.hui(viewHolder,i);
                return false;
            }
        });

        //错乱4
        viewHolder.ch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    map.put(i,b);
                }
            }
        });
        //错乱5
        if (map.get(i)==null){
            map.put(i,false);
        }
        viewHolder.ch.setChecked(map.get(i));


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
