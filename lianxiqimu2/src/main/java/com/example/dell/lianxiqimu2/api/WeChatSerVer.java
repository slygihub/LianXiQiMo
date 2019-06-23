package com.example.dell.lianxiqimu2.api;




import com.example.dell.lianxiqimu2.bean.WeChatBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface WeChatSerVer {
    String url="http://api.tianapi.com/wxnew/";

    @GET("?key=52b7ec3471ac3bec6846577e79f20e4c&num=10&page=1")
    Observable<WeChatBean> getdata();
}
