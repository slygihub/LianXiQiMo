package com.example.dell.lianxiqimu2.fuyong;


import android.view.View;
import android.widget.GridView;


import com.example.dell.lianxiqimu2.R;
import com.example.dell.lianxiqimu2.adapter.ZhuanAdapter;
import com.example.dell.lianxiqimu2.base.BaseMvpFragMent;
import com.example.dell.lianxiqimu2.bean.ZhuanLanBean;
import com.example.dell.lianxiqimu2.model.ZhuanLanM;
import com.example.dell.lianxiqimu2.person.ZhuanLanP;
import com.example.dell.lianxiqimu2.view.ZhuanLanV;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ZhuanlanFragMent extends BaseMvpFragMent<ZhuanLanP, ZhuanLanM, ZhuanLanV> implements ZhuanLanV {


    @BindView(R.id.lv)
    GridView lv;
    private ArrayList<ZhuanLanBean.DataBean> list;
    private ZhuanAdapter adapter;

    @Override
    protected void initView(View inflate) {
        super.initView(inflate);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zhuanlan;
    }

    @Override
    protected void initMvp() {
        super.initMvp();
        list = new ArrayList<>();
        adapter = new ZhuanAdapter(list, getContext());
        lv.setAdapter(adapter);
        myper.Yes();
    }

    @Override
    public void OnSeccess(ZhuanLanBean zhuanLanBean) {
        List<ZhuanLanBean.DataBean> data = zhuanLanBean.getData();
        list.addAll(data);
        adapter.setList(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected ZhuanLanV initview() {
        return this;
    }

    @Override
    protected ZhuanLanM initMoldel() {
        return new ZhuanLanM();
    }

    @Override
    protected ZhuanLanP initmyper() {
        return new ZhuanLanP();
    }

}
