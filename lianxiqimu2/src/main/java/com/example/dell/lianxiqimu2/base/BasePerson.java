package com.example.dell.lianxiqimu2.base;

public abstract class BasePerson<M extends BaseModel,V extends BaseView>{
protected M wodemodel;
protected V wodeview;

    public  void addModel(M m) {
        wodemodel=m;
    }

    public  void addView(V v) {
        wodeview=v;
    }
}
