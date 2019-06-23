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
import com.example.dell.lianxiqimu2.bean.ZhiHuBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class RiBaoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<ZhiHuBean.StoriesBean> list;
    private ArrayList<ZhiHuBean.TopStoriesBean> ban;
    private Context context;

    public RiBaoAdapter(ArrayList<ZhiHuBean.StoriesBean> list, ArrayList<ZhiHuBean.TopStoriesBean> ban, Context context) {
        this.list = list;
        this.ban = ban;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==0){
            View inflate = View.inflate(context, R.layout.ribaoitem1, null);
            ViewHolder1 holder1 = new ViewHolder1(inflate);
            return holder1;
        }else if (viewType==1){
            View inflate = View.inflate(context, R.layout.ribaoitem2, null);
            ViewHolder2 viewHolder2 = new ViewHolder2(inflate);
            return viewHolder2;
        }else{
            View inflate = View.inflate(context, R.layout.ribaoitem3, null);
            ViewHolder3 viewHolder3 = new ViewHolder3(inflate);
            return viewHolder3;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        if (type==0){
            ViewHolder1 holder1= (ViewHolder1) holder;
            holder1.ba.setImages(ban).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    ZhiHuBean.TopStoriesBean bb= (ZhiHuBean.TopStoriesBean) path;
                    Glide.with(context).load(bb.getImage()).into(imageView);
                }
            }).start();
        }else if (type==1){
            ViewHolder2 holder2= (ViewHolder2) holder;
            holder2.tv.setText("新闻日报");
        }else{
            int a=0;
            if (ban. size()>0){
                a=position-1;
            }else{
                a=position;
            }
            ViewHolder3 holder3= (ViewHolder3) holder;
            holder3.tv1.setText(list.get(a).getTitle());
            List<String> images = list.get(a).getImages();
            for (int i = 0; i < images.size(); i++) {
                Glide.with(context).load(images.get(i)).into(holder3.iv);
            }
        }
    }

    @Override
    public int getItemCount() {
        if (ban.size()>0){
           return list.size()+1;
        }else{
          return list.size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return 0;
        }else if (position==1){
            return 1;
        }else{
            return 2;
        }
    }

    class ViewHolder1 extends RecyclerView.ViewHolder{
        private Banner ba;
        public ViewHolder1(View itemView) {
            super(itemView);
            ba=itemView.findViewById(R.id.ba);
        }
    }

    class ViewHolder2 extends RecyclerView.ViewHolder {
        private TextView tv;

        public ViewHolder2(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
        }
    }

    class ViewHolder3 extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView tv1;

        public ViewHolder3(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv1 = itemView.findViewById(R.id.tv1);
        }
    }
}
