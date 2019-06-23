package com.example.dell.lianxiqimu2;

import android.support.annotation.NonNull;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;


import com.example.dell.lianxiqimu2.base.BaseActivity;
import com.example.dell.lianxiqimu2.fragment.CollectFragment;
import com.example.dell.lianxiqimu2.fragment.Fragmentgan;
import com.example.dell.lianxiqimu2.fragment.GoldFragment;
import com.example.dell.lianxiqimu2.fragment.GuanYuFragMent;
import com.example.dell.lianxiqimu2.fragment.SettingsFragment;
import com.example.dell.lianxiqimu2.fragment.V2exFragment;
import com.example.dell.lianxiqimu2.fragment.WechatFragment;
import com.example.dell.lianxiqimu2.fragment.ZhihuDailyNewsFragment;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;

import butterknife.BindView;


public class MainActivity extends BaseActivity {


    @BindView(R.id.tb)
    Toolbar tb;
    @BindView(R.id.fm)
    FrameLayout fm;
    @BindView(R.id.nv)
    NavigationView nv;
    @BindView(R.id.dl)
    DrawerLayout dl;
    @BindView(R.id.search_view)
    MaterialSearchView searchView;
    private FragmentManager manager;
    private int lastfragment;
    private ArrayList<Fragment> list;
    private int lastfragmentposition;
    private MenuItem anitem;

    @Override
    protected int LayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        tb.setTitle("知乎日报");
        setSupportActionBar(tb);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, dl, tb, 0, 0);
        dl.addDrawerListener(toggle);
        toggle.syncState();


        manager = getSupportFragmentManager();

        list = new ArrayList<>();
        list.add(new ZhihuDailyNewsFragment());
        list.add(new WechatFragment());
        list.add(new Fragmentgan());
        list.add(new GoldFragment());
        list.add(new V2exFragment());
        list.add(new CollectFragment());
        list.add(new SettingsFragment());
        list.add(new GuanYuFragMent());

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fm, list.get(0));
        tb.setTitle("知乎日报");
        transaction.commit();



        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                dl.closeDrawer(Gravity.LEFT);
                if (item.getItemId() == R.id.zhihu) {
                    tb.setTitle("知乎日报");
                    swithFragment(0);
                } else if (item.getItemId() == R.id.wechat) {
                    tb.setTitle("微信精选");
                    swithFragment(1);
                } else if (item.getItemId() == R.id.gank) {
                    tb.setTitle("干货集中营");
                    swithFragment(2);
                } else if (item.getItemId() == R.id.gold) {
                    tb.setTitle("稀土掘金");
                    swithFragment(3);
                } else if (item.getItemId() == R.id.vtex) {
                    tb.setTitle("V2EX");
                    swithFragment(4);
                } else if (item.getItemId() == R.id.link) {
                    tb.setTitle("收藏");
                    swithFragment(5);
                } else if (item.getItemId() == R.id.setting) {
                    tb.setTitle("设置");
                    swithFragment(6);
                } else if (item.getItemId() == R.id.about) {
                    tb.setTitle("关于");
                    swithFragment(7);
                }
                return true;
            }
        });
    }

    @Override
    protected void initListener() {
        super.initListener();
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, query, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Toast.makeText(MainActivity.this, newText, Toast.LENGTH_SHORT).show();
                return false;
            }
    });

        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                Toast.makeText(MainActivity.this, "打开了搜索框", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onSearchViewClosed() {
                Toast.makeText(MainActivity.this, "关闭了搜索框", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void swithFragment(int type) {
        Fragment fragment = list.get(type);
        Fragment lastfagment = list.get(this.lastfragmentposition);
        FragmentTransaction transaction = manager.beginTransaction();
        if (!fragment.isAdded()) {
            transaction.add(R.id.fm, fragment);
        }
       if (type==1||type==2){
            anitem.setVisible(true);
        }else {
            anitem.setVisible(false);
        }
        transaction.hide(lastfagment);
        transaction.show(fragment);
        transaction.commit();
        lastfragmentposition = type;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sousuo, menu);
        anitem = menu.findItem(R.id.sou);

        anitem.setVisible(false);
        searchView.setMenuItem(anitem);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {

        if (searchView.isSearchOpen()){
            searchView.closeSearch();
        }else{
            super.onBackPressed();
        }
    }
}
