package com.suman.foodmandu.api;

import com.suman.foodmandu.model.Flavour;
import com.suman.foodmandu.model.Spot;
import com.suman.foodmandu.model.Sweet;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface Flavourapi {

    @GET("flavours")
    Call<List<Flavour>> getfvp();
    @GET("sweets")
    Call<Flavour> getfvpimg(@Header("Authorization")String token);
}
