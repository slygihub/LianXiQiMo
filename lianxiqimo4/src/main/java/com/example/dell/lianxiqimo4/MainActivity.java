package com.example.dell.lianxiqimo4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.dell.lianxiqimo4.adapter.RecAdapter;
import com.example.dell.lianxiqimo4.contract.Contract;
import com.example.dell.lianxiqimo4.model.Model;
import com.example.dell.lianxiqimo4.presenter.Presenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Contract.View {

    private Toolbar tuo;
    private RecyclerView rec;
    private Button bt1;
    private Button bt2;
    private Button bt3;
    private ArrayList<Ben.DataBean> list;
    private RecAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setSupportActionBar(tuo);
        list = new ArrayList<>();
        adapter = new RecAdapter(list, this);
        rec.setAdapter(adapter);
        Presenter presenter = new Presenter(new Model(), this);
        presenter.p();


    }


    private void initView() {
        tuo = (Toolbar) findViewById(R.id.tuo);
        rec = (RecyclerView) findViewById(R.id.rec);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rec.setLayoutManager(manager);
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button) findViewById(R.id.bt3);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
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

                break;
            case R.id.bt3:
                if (adapter.isch) {
                    adapter.setIscheck(false);
                    adapter.notifyDataSetChanged();
                } else {
                    adapter.setIscheck(true);

                }
                break;
        }
    }

    @Override
    public void cheng(Ben ben) {
        List<Ben.DataBean> data = ben.getData();
        list.addAll(data);
        adapter.notifyDataSetChanged();
    }
}
