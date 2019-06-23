package com.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dell.lianxiqimo5.R;
import com.example.dell.lianxiqimo5.adapter.BRecAdapter;
import com.example.dell.lianxiqimo5.app.BenDao;
import com.example.dell.lianxiqimo5.app.Gong;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private RecyclerView rec;
    private ArrayList<BenDao> list;
    private BRecAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        list = new ArrayList<>();
        adapter = new BRecAdapter(list, this);
        rec.setAdapter(adapter);
        List<BenDao> query = Gong.getGong().query();
        list.addAll(query);
        adapter.notifyDataSetChanged();


    }

    private void initView() {
        rec = (RecyclerView) findViewById(R.id.rec);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rec.setLayoutManager(manager);
    }
}
