package com.example.dell.lianxiqimo.person;

import com.example.dell.lianxiqimo.ben.Bean;
import com.example.dell.lianxiqimo.callback.MyCallBack;
import com.example.dell.lianxiqimo.model.MyModel;
import com.example.dell.lianxiqimo.view.MyView;

public class MyPersonimp implements MyPersn, MyCallBack {
    private MyModel myModel;
    private MyView myView;

    public MyPersonimp(MyModel myModel, MyView myView) {
        this.myModel = myModel;
        this.myView = myView;
    }

    @Override
    public void p() {
        myModel.m(this);
    }

    @Override
    public void cheng(Bean bean) {
        myView.cheng(bean);
    }
}
