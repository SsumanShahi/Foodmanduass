package com.suman.foodmandu.api;

import com.suman.foodmandu.model.Details;
import com.suman.foodmandu.model.User;
import com.suman.foodmandu.model.username;
import com.suman.foodmandu.serverresponse.ImageResponse;
import com.suman.foodmandu.serverresponse.SignupResponse;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface Userapi {

    @GET("super7")
    Call<List<Details>> getsuper7();


    @POST("users/signup")
    Call<SignupResponse> registerUser(@Body User user);

//    @FormUrlEncoded
//    @POST("users/login")
//    Call<SignupResponse> checkUser(@Field("username") String username, @Field("password") String password);


    @POST("users/login")
    Call<SignupResponse> checklogin(@Body username ulogin);

    @Multipart
    @POST("upload")
    Call<ImageResponse> uploadImage(@Part MultipartBody.Part img);

    @GET("users/me")
    Call<User> getUserDetails(@Header("Authorization") String token);


    @GET("super7")
    Call<Details> getsuperDetails(@Header("Authorization")String token);
}
