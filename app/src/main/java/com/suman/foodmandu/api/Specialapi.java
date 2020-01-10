package com.suman.foodmandu.api;

import com.suman.foodmandu.model.Details;
import com.suman.foodmandu.model.Special;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface Specialapi {

    @GET("special")
    Call<List<Special>> getspecial();


    @GET("special")
    Call<Special> getspecailimage(@Header("Authorization")String token);
}
