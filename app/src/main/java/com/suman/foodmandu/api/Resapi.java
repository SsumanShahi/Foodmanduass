package com.suman.foodmandu.api;

import com.suman.foodmandu.model.Restaurant;
import com.suman.foodmandu.model.Sweet;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface Resapi {
    @GET("Resturants")
    Call<List<Restaurant>> getrs();
    @GET("sweets")
    Call<Restaurant> getrsimg(@Header("Authorization")String token);
}
