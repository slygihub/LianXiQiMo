package com.example.dell.lianxiqimu2.person;


import com.example.dell.lianxiqimu2.base.BaseCallBack;
import com.example.dell.lianxiqimu2.base.BasePerson;
import com.example.dell.lianxiqimu2.bean.ZhuanLanBean;
import com.example.dell.lianxiqimu2.model.ZhuanLanM;
import com.example.dell.lianxiqimu2.view.ZhuanLanV;

public class ZhuanLanP extends BasePerson<ZhuanLanM,ZhuanLanV> {
    public void Yes(){
        if (wodemodel!=null){
            wodemodel.zhuanlan(new BaseCallBack<ZhuanLanBean>() {
                @Override
                public void Yes(ZhuanLanBean zhuanLanBean) {
                    wodeview.OnSeccess(zhuanLanBean);
                }
            });
        }
    }
}
