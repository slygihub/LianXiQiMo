package com.example.dell.lianxiqimu2.net;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpUtils {
    private static HttpUtils httpUtils;
    private final Retrofit.Builder builder;

    public HttpUtils() {
        builder = new Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create());

    }

    public static HttpUtils getHttpUtils() {
        if (httpUtils == null) {
            synchronized (HttpUtils.class){
                if (httpUtils == null) {
                    httpUtils=new HttpUtils();
                }
            }
        }
        return httpUtils;
    }
    public <T> T getserver(String url,Class<T> tClass){
        return builder.baseUrl(url).build().create(tClass);
    }
}
