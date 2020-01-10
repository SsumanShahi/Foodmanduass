package com.suman.foodmandu.api;

import com.suman.foodmandu.model.Alchohol;
import com.suman.foodmandu.model.Globe;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface Globeapi {
    @GET("globes")
    Call<List<Globe>> getglb();
    @GET("globes")
    Call<Globe> getglbimg(@Header("Authorization")String token);
}
