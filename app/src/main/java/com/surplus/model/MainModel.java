package com.surplus.model;

import com.surplus.App;
import com.surplus.constraint.MainConstraint;
import com.surplus.data.UserFacade;
import com.surplus.data.entity.LoginEntity;
import com.surplus.http.Api;
import com.surplus.http.entity.LoginParam;
import com.surplus.util.EncryptUtil;
import com.surplus.util.LocalUtil;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.surplus.util.EncryptUtil.encrypt;

public class MainModel implements MainConstraint.IModel{

    @Override
    public Observable<LoginEntity> getData() {

        LoginParam param = new LoginParam();
        param.user_name = "13554755002";
        param.password = encrypt("123456", EncryptUtil.DESKEY); // 经过DES加密的数据
        param.login_type = "1";
        param.device_id = LocalUtil.getDeviceId(App.getContext());
        param.device_name = android.os.Build.MODEL;
        param.device_mark = "device";
        param.device_code = null;
        param.accessid  = UserFacade.getIns().getAccessId();
        return Api.getApiService().login(param).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

}
