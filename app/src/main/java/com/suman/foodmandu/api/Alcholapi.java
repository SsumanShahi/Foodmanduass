package com.suman.foodmandu.api;

import com.suman.foodmandu.model.Alchohol;
import com.suman.foodmandu.model.Details;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface Alcholapi {
    @GET("alcohol")
    Call<List<Alchohol>> getalc();
    @GET("alcohol")
    Call<Alchohol> getaclimg(@Header("Authorization")String token);
}
