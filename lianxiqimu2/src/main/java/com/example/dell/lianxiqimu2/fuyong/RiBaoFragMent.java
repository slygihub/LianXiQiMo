package com.example.dell.lianxiqimu2.fuyong;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import com.example.dell.lianxiqimu2.R;
import com.example.dell.lianxiqimu2.adapter.RiBaoAdapter;
import com.example.dell.lianxiqimu2.base.BaseMvpFragMent;
import com.example.dell.lianxiqimu2.bean.ZhiHuBean;
import com.example.dell.lianxiqimu2.model.Model;

import com.example.dell.lianxiqimu2.person.Persement;
import com.example.dell.lianxiqimu2.view.MyView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 收藏
 */
public class RiBaoFragMent extends BaseMvpFragMent<Persement,Model,MyView> implements MyView {


    @BindView(R.id.rc)
    RecyclerView rc;
    private ArrayList<ZhiHuBean.StoriesBean> list;
    private ArrayList<ZhiHuBean.TopStoriesBean> ban;
    private RiBaoAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_ribao;
    }

    @Override
    public void OnSeccess(ZhiHuBean zhiHuBean) {
        List<ZhiHuBean.StoriesBean> stories = zhiHuBean.getStories();
        List<ZhiHuBean.TopStoriesBean> top_stories = zhiHuBean.getTop_stories();
        list.addAll(stories);
        ban.addAll(top_stories);
        adapter.notifyDataSetChanged();

    }

    @Override
    protected void initView(View inflate) {
        super.initView(inflate);
    }

    @Override
    protected void initMvp() {
        super.initMvp();
        rc.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        ban = new ArrayList<>();
        adapter = new RiBaoAdapter(list, ban, getContext());
        rc.setAdapter(adapter);
        myper.Yes();
    }

    @Override
    protected MyView initview() {
        return this;
    }

    @Override
    protected Model initMoldel() {
        return new Model();
    }

    @Override
    protected Persement initmyper() {
        return new Persement();
    }
}
