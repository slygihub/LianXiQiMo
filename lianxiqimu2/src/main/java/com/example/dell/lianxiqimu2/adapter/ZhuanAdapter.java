package com.example.dell.lianxiqimu2.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.dell.lianxiqimu2.R;
import com.example.dell.lianxiqimu2.bean.ZhuanLanBean;


import java.util.ArrayList;

public class ZhuanAdapter extends BaseAdapter {
    private ArrayList<ZhuanLanBean.DataBean> list;
    private Context context;

    public void setList(ArrayList<ZhuanLanBean.DataBean> list) {
        this.list = list;
    }

    public ZhuanAdapter(ArrayList<ZhuanLanBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (convertView==null){
            holder=new ViewHolder();
           convertView= View.inflate(context, R.layout.zhuanlanitem, null);
           holder.iv2=convertView.findViewById(R.id.iv2);
           convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }

        Glide.with(context).load(list.get(position).getThumbnail()).into(holder.iv2);
        return convertView;
    }
    class ViewHolder{
        ImageView iv2;
    }
}
