package com.example.dell.lianxiqimu2.model;








import com.example.dell.lianxiqimu2.api.MyServers;
import com.example.dell.lianxiqimu2.base.BaseCallBack;
import com.example.dell.lianxiqimu2.base.BaseModel;
import com.example.dell.lianxiqimu2.bean.ReMenBean;
import com.example.dell.lianxiqimu2.net.BaseObservers;
import com.example.dell.lianxiqimu2.net.HttpUtils;
import com.example.dell.lianxiqimu2.net.RxUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class ReMenM extends BaseModel {
    public void jiazai(final BaseCallBack<ReMenBean> baseCallBack){
        MyServers servers = HttpUtils.getHttpUtils().getserver(MyServers.url, MyServers.class);
        Observable<ReMenBean> reMenBeanObservable = servers.getdata2();
       reMenBeanObservable.compose(RxUtils.<ReMenBean>rxobserabler())
               .subscribe(new BaseObservers<ReMenBean>() {
                   @Override
                   public void onSubscribe(Disposable d) {

                   }

                   @Override
                   public void onNext(ReMenBean reMenBean) {
                       baseCallBack.Yes(reMenBean);
                   }
               });



    }
}
