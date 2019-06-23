package com.example.dell.lianxiqimu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dell.lianxiqimu.Ben.BasUrl;
import com.example.dell.lianxiqimu.Ben.Ben;
import com.example.dell.lianxiqimu.adapter.RecAdapter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main2Activity extends AppCompatActivity {

    private EditText shouji;
    private EditText mima;
    private TextView zhanghu;

    private Toolbar tuo;
    private RecyclerView rec;
    private ArrayList<Ben.DataBean.ListBean> list;
    private RecAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        //setSupportActionBar(tuo);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        zhanghu.setText("账户余额:" + name);

        list = new ArrayList<>();
        adapter = new RecAdapter(list, this);
        rec.setAdapter(adapter);
        OkHttpClient client = new OkHttpClient.Builder().build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(BasUrl.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        BasUrl basUrl = retrofit.create(BasUrl.class);
        Observable<Ben> data = basUrl.getData();
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Ben>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Ben ben) {
                        List<Ben.DataBean.ListBean> listBeans = ben.getData().getList();
                        list.addAll(listBeans);
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    private void initView() {
        shouji = (EditText) findViewById(R.id.shouji);
        mima = (EditText) findViewById(R.id.mima);
        zhanghu = (TextView) findViewById(R.id.zhanghu);


        tuo = (Toolbar) findViewById(R.id.tuo);
        rec = (RecyclerView) findViewById(R.id.rec);
        LinearLayoutManager manager = new LinearLayoutManager(this);

        rec.setLayoutManager(manager);
    }


}
