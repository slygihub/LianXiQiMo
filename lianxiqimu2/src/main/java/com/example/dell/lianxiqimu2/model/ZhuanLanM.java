package com.example.dell.lianxiqimu2.model;




import com.example.dell.lianxiqimu2.api.MyServers;
import com.example.dell.lianxiqimu2.base.BaseCallBack;
import com.example.dell.lianxiqimu2.base.BaseModel;
import com.example.dell.lianxiqimu2.bean.ZhuanLanBean;
import com.example.dell.lianxiqimu2.net.BaseObservers;
import com.example.dell.lianxiqimu2.net.HttpUtils;
import com.example.dell.lianxiqimu2.net.RxUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class ZhuanLanM extends BaseModel {
    public void zhuanlan(final BaseCallBack<ZhuanLanBean> baseCallBack) {
        MyServers servers = HttpUtils.getHttpUtils().getserver(MyServers.url, MyServers.class);
        Observable<ZhuanLanBean> getdata1 = servers.getdata1();
        getdata1.compose(RxUtils.<ZhuanLanBean>rxobserabler()).subscribe(new BaseObservers<ZhuanLanBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ZhuanLanBean zhuanLanBean) {
                baseCallBack.Yes(zhuanLanBean);
            }
        });
    }
}
