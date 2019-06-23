package com.example.dell.lianxiqimu2.fragment;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.dell.lianxiqimu2.R;
import com.example.dell.lianxiqimu2.adapter.WeChatAdapter;
import com.example.dell.lianxiqimu2.base.BaseMvpFragMent;
import com.example.dell.lianxiqimu2.bean.WeChatBean;
import com.example.dell.lianxiqimu2.model.WeChatM;
import com.example.dell.lianxiqimu2.person.WeChatP;
import com.example.dell.lianxiqimu2.view.WeChatV;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class WechatFragment extends BaseMvpFragMent<WeChatP, WeChatM, WeChatV> implements WeChatV {

    @BindView(R.id.rc)
    XRecyclerView rc;
    private ArrayList<WeChatBean.NewslistBean> list;
    private WeChatAdapter adapter;

    @Override
    protected WeChatV initview() {
        return this;
    }

    @Override
    protected WeChatM initMoldel() {
        return new WeChatM();
    }

    @Override
    protected WeChatP initmyper() {
        return new WeChatP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wechat;
    }

    @Override
    protected void initMvp() {
        super.initMvp();
        rc.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        adapter = new WeChatAdapter(list, getContext());
        rc.setAdapter(adapter);
        myper.per();
    }

    @Override
    public void OnSeccess(WeChatBean weChatBean) {
        List<WeChatBean.NewslistBean> list1 = weChatBean.getNewslist();
        list.addAll(list1);
        adapter.notifyDataSetChanged();
    }
}
