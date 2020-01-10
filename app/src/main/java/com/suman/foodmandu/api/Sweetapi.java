package com.suman.foodmandu.api;

import com.suman.foodmandu.model.Details;
import com.suman.foodmandu.model.Sweet;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface Sweetapi {
    @GET("sweets")
    Call<List<Sweet>> getsweet();
    @GET("sweets")
    Call<Sweet> getswtimg(@Header("Authorization")String token);
}
