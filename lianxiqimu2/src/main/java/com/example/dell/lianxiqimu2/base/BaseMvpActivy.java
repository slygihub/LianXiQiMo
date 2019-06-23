package com.example.dell.lianxiqimu2.base;

public abstract class BaseMvpActivy<P extends BasePerson,M extends BaseModel,V extends BaseView> extends BaseActivity{
    protected P myper;

    @Override
    protected void initMvp() {
        super.initMvp();
        myper=initMyPerson();
        myper.addModel(initModel());
        myper.addView(initview());
    }

    protected abstract V initview();

    protected abstract M initModel();

    protected abstract P initMyPerson();


}
