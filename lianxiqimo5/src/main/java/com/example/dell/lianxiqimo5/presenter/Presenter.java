package com.example.dell.lianxiqimo5.presenter;

import com.example.dell.lianxiqimo5.ben.Bean;
import com.example.dell.lianxiqimo5.contract.Contract;

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
    public void chenng(Bean bean) {
     view.chenng(bean);
    }
}
