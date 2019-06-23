package com.example.dell.lianxiqimo5.model;

import com.example.dell.lianxiqimo5.ben.Basurl;
import com.example.dell.lianxiqimo5.ben.Bean;
import com.example.dell.lianxiqimo5.contract.Contract;

import javax.crypto.spec.RC2ParameterSpec;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Model implements Contract.Model {
    @Override
    public void m(final Contract contract) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Basurl.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Basurl basurl = retrofit.create(Basurl.class);
        Observable<Bean> getdata = basurl.getdata();
        getdata.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Bean bean) {
                        contract.chenng(bean);
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
