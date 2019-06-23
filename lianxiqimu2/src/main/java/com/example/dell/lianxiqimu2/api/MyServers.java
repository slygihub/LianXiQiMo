package com.example.dell.lianxiqimu2.api;




;import com.example.dell.lianxiqimu2.bean.ReMenBean;
import com.example.dell.lianxiqimu2.bean.ZhiHuBean;
import com.example.dell.lianxiqimu2.bean.ZhuanLanBean;

import io.reactivex.Observable;
import retrofit2.http.GET;


public interface MyServers {
    String url="http://news-at.zhihu.com/api/4/";
    @GET("news/latest")
    Observable<ZhiHuBean> getdata();

    @GET("sections")
    Observable<ZhuanLanBean> getdata1();


    @GET("news/hot")
    Observable<ReMenBean> getdata2();



}
