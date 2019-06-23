package com.example.dell.lianxiqimo4.presenter;

import com.example.dell.lianxiqimo4.Ben;
import com.example.dell.lianxiqimo4.contract.Contract;

public class Presenter implements Contract.Presenter, Contract {
    private Contract.Model model;
    private Contract.View view;

    public Presenter(Contract.Model model, Contract.View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void p() {
        model.m(this);
    }

    @Override
    public void cheng(Ben ben) {
        view.cheng(ben);
    }
}
