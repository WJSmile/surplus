package com.surplus.mvp;

import java.lang.ref.WeakReference;

public class BasePresenter<M extends BaseModel,V extends BaseView> {
    public M mModel;
    public WeakReference<V> mView;


    public void onAttach(M model, V view) {
        mModel = model;
        mView = new WeakReference<V>(view);
    }

    public void onDestroy(){
        if (mView!=null){
            mView.clear();
            mView =null;
        }
        if (mModel!=null){
            mModel =null;
        }
    }
}
