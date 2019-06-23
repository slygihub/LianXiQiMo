package com.example.dell.lianxiqimo5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.Main2Activity;
import com.example.dell.lianxiqimo5.adapter.RecAdapter;
import com.example.dell.lianxiqimo5.ben.Bean;
import com.example.dell.lianxiqimo5.contract.Contract;
import com.example.dell.lianxiqimo5.model.Model;
import com.example.dell.lianxiqimo5.presenter.Presenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Contract.View {

    private RecyclerView rec;
    private Button bt1;
    private Button bt2;
    private Button bt3;
    private ArrayList<Bean.DataBean> list;
    private RecAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        list = new ArrayList<>();
        adapter = new RecAdapter(list, this);
        rec.setAdapter(adapter);
        Presenter presenter = new Presenter(new Model(), this);
        presenter.p();
    }

    private void initView() {
        rec = (RecyclerView) findViewById(R.id.rec);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rec.setLayoutManager(manager);
        bt1 = (Button) findViewById(R.id.bt1);
        bt1.setOnClickListener(this);
        bt2 = (Button) findViewById(R.id.bt2);
        bt2.setOnClickListener(this);
        bt3 = (Button) findViewById(R.id.bt3);
        bt3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt1:
                if (adapter.isch) {
                    adapter.setIscheck(false);
                    // adapter.notifyDataSetChanged();
                } else {
                    adapter.setIscheck(true);
                    adapter.notifyDataSetChanged();
                }

                break;
            case R.id.bt2:
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.bt3:
                if (adapter.isch) {
                    adapter.setIscheck(false);
                    adapter.notifyDataSetChanged();
                } else {
                    adapter.setIscheck(true);
                    //adapter.notifyDataSetChanged();
                }
                break;
        }
    }

    @Override
    public void chenng(Bean bean) {
        List<Bean.DataBean> data = bean.getData();
        list.addAll(data);
        adapter.notifyDataSetChanged();
    }
}
