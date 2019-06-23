package com.example.dell.lianxiqimu2.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.dell.lianxiqimu2.R;
import com.example.dell.lianxiqimu2.adapter.JieHeadapter;
import com.example.dell.lianxiqimu2.ganhuofragment.Androidf;
import com.example.dell.lianxiqimu2.ganhuofragment.Fuli;
import com.example.dell.lianxiqimu2.ganhuofragment.iOS;
import com.example.dell.lianxiqimu2.ganhuofragment.qianduan;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragmentgan extends Fragment {


    private TabLayout tab;
    private ViewPager vp;
    private String[] names={"Androidf","ios","前端","福利"};

    public Fragmentgan() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_fragmentgan, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        tab = (TabLayout) inflate.findViewById(R.id.tab);
        vp = (ViewPager) inflate.findViewById(R.id.vp);
        tab.setupWithViewPager(vp);
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new Androidf());
        list.add(new iOS());
        list.add(new qianduan());
        list.add(new Fuli());

        JieHeadapter jieHeadapter = new JieHeadapter(getChildFragmentManager(), list, names);
        vp.setAdapter(jieHeadapter);


    }
}
