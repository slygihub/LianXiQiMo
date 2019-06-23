package com.example.dell.lianxiqimu2.api;




import com.example.dell.lianxiqimu2.bean.AndroidBean;
import com.example.dell.lianxiqimu2.bean.FuLiBean;
import com.example.dell.lianxiqimu2.bean.IosBean;
import com.example.dell.lianxiqimu2.bean.QianDuanBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Servers {
    String url1="http://gank.io/api/data/Android/20/";
    String url2="http://gank.io/api/data/iOS/20/";
    String url3="http://gank.io/api/data/前端/20/";
    String url4="http://gank.io/api/data/福利/20/";

   @GET("1")
   Observable<AndroidBean> androiddata();

    @GET("1")
    Observable<IosBean> iosdata();

    @GET("1")
    Observable<QianDuanBean> qianduan();

    @GET("1")
    Observable<FuLiBean> fulidata();

}
