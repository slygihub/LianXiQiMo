package com.example.dell.lianxiqimu2.adapter;


import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class JieHeadapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> list;
    private String[] names;

    public JieHeadapter(FragmentManager fm, ArrayList<Fragment> list, String[] names) {
        super(fm);
        this.list = list;
        this.names = names;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return names[position];
    }
}
