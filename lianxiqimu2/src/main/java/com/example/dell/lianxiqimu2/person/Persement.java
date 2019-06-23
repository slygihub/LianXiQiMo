package com.example.dell.lianxiqimu2.person;


import com.example.dell.lianxiqimu2.base.BaseCallBack;
import com.example.dell.lianxiqimu2.base.BasePerson;
import com.example.dell.lianxiqimu2.bean.ZhiHuBean;
import com.example.dell.lianxiqimu2.model.Model;
import com.example.dell.lianxiqimu2.view.MyView;

public class Persement extends BasePerson<Model, MyView> {
    public void Yes() {
        if (wodemodel != null) {
            wodemodel.Yes(new BaseCallBack<ZhiHuBean>() {
                @Override
                public void Yes(ZhiHuBean zhiHuBean) {
                    wodeview.OnSeccess(zhiHuBean);
                }
            });
        }
    }
}
