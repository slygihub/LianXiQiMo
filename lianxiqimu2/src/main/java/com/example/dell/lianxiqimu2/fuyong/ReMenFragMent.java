package com.example.dell.lianxiqimu2.fuyong;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import com.example.dell.lianxiqimu2.R;
import com.example.dell.lianxiqimu2.adapter.ReMenAdapter;
import com.example.dell.lianxiqimu2.base.BaseMvpFragMent;
import com.example.dell.lianxiqimu2.bean.ReMenBean;
import com.example.dell.lianxiqimu2.model.ReMenM;
import com.example.dell.lianxiqimu2.person.ReMenP;
import com.example.dell.lianxiqimu2.view.ReMenV;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 收藏
 */
public class ReMenFragMent extends BaseMvpFragMent<ReMenP, ReMenM, ReMenV> implements ReMenV {


    @BindView(R.id.rc)
    RecyclerView rc;
    //Unbinder unbinder;
    private ArrayList<ReMenBean.RecentBean> list;
    private ReMenAdapter adapter;

    @Override
    protected void initView(View inflate) {
        super.initView(inflate);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_remen;
    }

    @Override
    protected void initMvp() {
        super.initMvp();
        rc.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        adapter = new ReMenAdapter(list, getContext());
        rc.setAdapter(adapter);
        myper.myper();
    }

    @Override
    public void OnSeccess(ReMenBean reMenBean) {
        List<ReMenBean.RecentBean> recent = reMenBean.getRecent();
        list.addAll(recent);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected ReMenV initview() {
        return this;
    }

    @Override
    protected ReMenM initMoldel() {
        return new ReMenM();
    }

    @Override
    protected ReMenP initmyper() {
        return new ReMenP();
    }

}
