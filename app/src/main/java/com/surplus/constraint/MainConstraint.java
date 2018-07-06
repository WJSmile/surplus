package com.surplus.constraint;

import com.surplus.data.entity.LoginEntity;
import com.surplus.mvp.BaseModel;
import com.surplus.mvp.BaseView;

import io.reactivex.Observable;

public interface MainConstraint {

    interface IView extends BaseView{
        void start(String s);
    }

    interface IModel extends BaseModel{
        Observable<LoginEntity> getData();
    }
}
