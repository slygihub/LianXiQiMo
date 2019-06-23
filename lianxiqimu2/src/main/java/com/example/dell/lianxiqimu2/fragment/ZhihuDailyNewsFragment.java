package com.example.dell.lianxiqimu2.fragment;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;


import com.example.dell.lianxiqimu2.R;
import com.example.dell.lianxiqimu2.adapter.MyJieHeAdapter;
import com.example.dell.lianxiqimu2.base.BaseFragment;
import com.example.dell.lianxiqimu2.fuyong.ReMenFragMent;
import com.example.dell.lianxiqimu2.fuyong.RiBaoFragMent;
import com.example.dell.lianxiqimu2.fuyong.ZhuanlanFragMent;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;

public class ZhihuDailyNewsFragment extends BaseFragment {
    private String[] names = {"日报", "专栏", "热门"};
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    Unbinder unbinder;


    @Override
    protected void initView(View inflate) {
        super.initView(inflate);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zhihu_daily_news;
    }

    @Override
    protected void initData() {
        tab.setupWithViewPager(vp);
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new RiBaoFragMent());
        list.add(new ZhuanlanFragMent());
        list.add(new ReMenFragMent());
        MyJieHeAdapter adapter = new MyJieHeAdapter(getChildFragmentManager(), list, names);
        vp.setAdapter(adapter);
    }


}
