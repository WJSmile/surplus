package com.surplus.http;

import com.surplus.data.entity.LoginEntity;
import com.surplus.http.entity.LoginParam;


import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    @POST("user_login")
    Observable<LoginEntity> login(@Body LoginParam param);
}
