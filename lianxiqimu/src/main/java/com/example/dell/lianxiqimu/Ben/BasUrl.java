package com.example.dell.lianxiqimu.Ben;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface BasUrl {
    String url="http://106.13.63.54:8080/sys/xin195yk/";
    @GET("jiekou.json")
    Observable<Ben>getData();
}
