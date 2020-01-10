package com.suman.foodmandu.api;

import com.suman.foodmandu.model.Spot;
import com.suman.foodmandu.model.Sweet;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface Spotapi {
    @GET("spots")
    Call<Spot> getsptimg(@Header("Authorization")String token);
}
