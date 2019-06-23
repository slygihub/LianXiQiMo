package com.example.dell.lianxiqimu2.ganhuofragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.dell.lianxiqimu2.R;
import com.example.dell.lianxiqimu2.adapter.IosAdapter;
import com.example.dell.lianxiqimu2.api.Servers;
import com.example.dell.lianxiqimu2.bean.IosBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */

public class iOS extends Fragment {


    private RecyclerView rc;
    private ArrayList<IosBean.ResultsBean> list;
    private IosAdapter adapter;

    public iOS() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.ios, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        rc = (RecyclerView) inflate.findViewById(R.id.rc);
        rc.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        adapter = new IosAdapter(list, getContext());
        rc.setAdapter(adapter);

        Retrofit retrofit = new Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).baseUrl(Servers.url2).build();
        Servers servers = retrofit.create(Servers.class);
        Observable<IosBean> iosdata = servers.iosdata();
        iosdata.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<IosBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(IosBean iosBean) {
                        List<IosBean.ResultsBean> list1 = iosBean.getResults();
                        list.addAll(list1);
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
}
