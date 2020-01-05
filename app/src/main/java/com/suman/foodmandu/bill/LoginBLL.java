package com.suman.foodmandu.bill;

import com.suman.foodmandu.Url.url;
import com.suman.foodmandu.api.Userapi;
import com.suman.foodmandu.serverresponse.SignupResponse;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class LoginBLL {

    boolean isSuccess = false;

    public boolean checkUser(String username, String password){

        Userapi userapi = url.getInstance().create(Userapi.class);
        Call<SignupResponse> usercall = userapi.checkUser(username, password);

        try {
            Response<SignupResponse> loginResponse = usercall.execute();
            if (loginResponse.isSuccessful() && loginResponse.body().getStatus().equals("Login Successfull"))
            {
                url.token += loginResponse.body().getToken();
//                url.Cookie = imageResponseResponse.headers().get("Set=Cookie");
                isSuccess = true;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return isSuccess;

    }
}
