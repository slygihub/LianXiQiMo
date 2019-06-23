package com.example.dell.lianxiqimu2.base;

public abstract class BaseMvpFragMent<P extends BasePerson,M extends BaseModel,V extends BaseView> extends BaseFragment{
    protected P myper;
    @Override
    protected void initMvp() {
        super.initMvp();
        myper=initmyper();
        if (myper!=null){
            myper.addModel(initMoldel());
            myper.addView(initview());
        }
    }

    protected abstract V initview();

    protected abstract M initMoldel();

    protected abstract P initmyper();
}
