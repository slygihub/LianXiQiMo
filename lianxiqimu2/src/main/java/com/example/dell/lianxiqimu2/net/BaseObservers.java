package com.example.dell.lianxiqimu2.net;

import io.reactivex.Observer;

public abstract class BaseObservers<T> implements Observer<T> {
    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
