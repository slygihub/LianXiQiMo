package com.example.dell.lianxiqimo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar tuo;
    private FrameLayout frag;
    private TabLayout tab;
    private ArrayList<Fragment> list;
    private FragmentManager manager;
private int last;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setSupportActionBar(tuo);
        list = new ArrayList<>();
        list.add(new AFragment());
        list.add(new BFragment());
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.frag,list.get(0));
        transaction.show(list.get(0));
        transaction.commit();
        tab.addTab(tab.newTab().setText("故事").setIcon(R.mipmap.ic_launcher));
        tab.addTab(tab.newTab().setText("亲子").setIcon(R.mipmap.ic_launcher));
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position==0){
                    swithfragment(0);
                }else if (position==1){
                    swithfragment(1);
                }
            }


            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initView() {
        tuo = (Toolbar) findViewById(R.id.tuo);
        frag = (FrameLayout) findViewById(R.id.frag);
        tab = (TabLayout) findViewById(R.id.tab);
    }
    private void swithfragment(int type) {
        Fragment fragment = list.get(type);
        Fragment lastfragment = list.get(this.last);
        FragmentTransaction transaction = manager.beginTransaction();
        if (!fragment.isAdded()){
            transaction.add(R.id.frag,fragment);
        }
        transaction.show(fragment);
        transaction.hide(lastfragment);
        transaction.commit();
        last=type;
    }

}
