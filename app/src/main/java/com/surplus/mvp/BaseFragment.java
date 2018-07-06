package com.surplus.mvp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment {

    private int layoutId = 1;
    private P mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layoutId = getLayoutId();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (layoutId != 1){
            View view = inflater.inflate(layoutId,container,false);
            ButterKnife.bind(this,view);
            return view;
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public abstract int getLayoutId();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter.onDestroy();
            mPresenter = null;
        }
    }
}
