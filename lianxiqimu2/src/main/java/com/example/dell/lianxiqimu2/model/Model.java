package com.example.dell.lianxiqimu2.model;



import com.example.dell.lianxiqimu2.api.MyServers;
import com.example.dell.lianxiqimu2.base.BaseCallBack;
import com.example.dell.lianxiqimu2.base.BaseModel;
import com.example.dell.lianxiqimu2.bean.ZhiHuBean;
import com.example.dell.lianxiqimu2.net.BaseObservers;
import com.example.dell.lianxiqimu2.net.HttpUtils;
import com.example.dell.lianxiqimu2.net.RxUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class Model extends BaseModel {
    public void Yes(final BaseCallBack<ZhiHuBean> baseCallBack){
        MyServers servers = HttpUtils.getHttpUtils().getserver(MyServers.url, MyServers.class);
        Observable<ZhiHuBean> getdata = servers.getdata();
        getdata.compose(RxUtils.<ZhiHuBean>rxobserabler())
                .subscribe(new BaseObservers<ZhiHuBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ZhiHuBean zhiHuBean) {
                        baseCallBack.Yes(zhiHuBean);
                    }
                });




    }
}
