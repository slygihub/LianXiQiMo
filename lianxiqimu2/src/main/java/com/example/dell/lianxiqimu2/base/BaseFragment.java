package com.example.dell.lianxiqimu2.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {

    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayoutId(), null);
        bind = ButterKnife.bind(this, inflate);
        initView(inflate);
        initData();
        initListener();
        initMvp();
        return inflate;
    }

    protected void initMvp() {

    }

    protected void initListener() {

    }

    protected void initData() {

    }

    protected void initView(View inflate) {

    }

    protected abstract int getLayoutId();
}
