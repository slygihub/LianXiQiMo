package com.example.dell.lianxiqimu2.model;



import com.example.dell.lianxiqimu2.api.WeChatSerVer;
import com.example.dell.lianxiqimu2.base.BaseCallBack;
import com.example.dell.lianxiqimu2.base.BaseModel;
import com.example.dell.lianxiqimu2.bean.WeChatBean;
import com.example.dell.lianxiqimu2.net.BaseObservers;
import com.example.dell.lianxiqimu2.net.HttpUtils;
import com.example.dell.lianxiqimu2.net.RxUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class WeChatM extends BaseModel {
    public void Yes(final BaseCallBack<WeChatBean> baseCallBack){
        WeChatSerVer getserver = HttpUtils.getHttpUtils().getserver(WeChatSerVer.url, WeChatSerVer.class);
        Observable<WeChatBean> getdata = getserver.getdata();
        getdata.compose(RxUtils.<WeChatBean>rxobserabler())
                .subscribe(new BaseObservers<WeChatBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WeChatBean weChatBean) {
                            baseCallBack.Yes(weChatBean);
                    }
                });
    }
}
