package com.example.dell.lianxiqimu2.person;


import com.example.dell.lianxiqimu2.base.BaseCallBack;
import com.example.dell.lianxiqimu2.base.BasePerson;
import com.example.dell.lianxiqimu2.bean.ReMenBean;
import com.example.dell.lianxiqimu2.model.ReMenM;
import com.example.dell.lianxiqimu2.view.ReMenV;

public class ReMenP extends BasePerson<ReMenM, ReMenV> {
    public void myper() {
        if (wodemodel != null) {
            wodemodel.jiazai(new BaseCallBack<ReMenBean>() {
                @Override
                public void Yes(ReMenBean reMenBean) {
                    wodeview.OnSeccess(reMenBean);
                }
            });
        }
    }
}
