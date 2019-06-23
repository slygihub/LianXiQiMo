package com.example.dell.lianxiqimu2.person;


import com.example.dell.lianxiqimu2.base.BaseCallBack;
import com.example.dell.lianxiqimu2.base.BasePerson;
import com.example.dell.lianxiqimu2.bean.WeChatBean;
import com.example.dell.lianxiqimu2.model.WeChatM;
import com.example.dell.lianxiqimu2.view.WeChatV;

public class WeChatP extends BasePerson<WeChatM,WeChatV> {
    public void per(){
        if (wodemodel!=null){
            wodemodel.Yes(new BaseCallBack<WeChatBean>() {
                @Override
                public void Yes(WeChatBean weChatBean) {
                    wodeview.OnSeccess(weChatBean);
                }
            });
        }
    }
}
