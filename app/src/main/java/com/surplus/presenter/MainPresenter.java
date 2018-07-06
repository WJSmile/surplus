package com.surplus.presenter;

import com.surplus.constraint.MainConstraint;
import com.surplus.data.entity.LoginEntity;
import com.surplus.mvp.BasePresenter;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainPresenter extends BasePresenter<MainConstraint.IModel,MainConstraint.IView> {

    @Override
    public void onAttach(MainConstraint.IModel model, MainConstraint.IView view) {
        super.onAttach(model, view);

        mModel.getData().subscribe(new Observer<LoginEntity>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(LoginEntity loginEntity) {
                mView.get().start(loginEntity.getResponse().getInfo().getMsg());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
