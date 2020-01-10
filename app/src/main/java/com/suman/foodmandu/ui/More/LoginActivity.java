package com.suman.foodmandu.ui.More;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.suman.foodmandu.DashboardActivity;
import com.suman.foodmandu.MainActivity;
import com.suman.foodmandu.R;
import com.suman.foodmandu.Url.url;
import com.suman.foodmandu.api.Userapi;
import com.suman.foodmandu.bill.LoginBLL;
import com.suman.foodmandu.model.username;
import com.suman.foodmandu.serverresponse.SignupResponse;
import com.suman.foodmandu.strictmode.StrictModeClass;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText etemail, etpassword;
    private Button btnlogin, btnfb, btngoogle;
    private TextView tvaccount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etemail = findViewById(R.id.etemail);
        etpassword = findViewById(R.id.etpassword);
        btnlogin = findViewById(R.id.btnlogin);
        btnfb = findViewById(R.id.btnfb);
        btngoogle = findViewById(R.id.btngoogle);
        tvaccount = findViewById(R.id.tvaccount);

        tvaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignupActivity.class));
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {

        String username = etemail.getText().toString();
        String password = etpassword.getText().toString();


        LoginBLL loginBLL = new LoginBLL();
        com.suman.foodmandu.model.username Username = new username(username, password);

        StrictModeClass.StrictMode();
        Userapi userapi = url.getInstance().create(Userapi.class);
        Call<SignupResponse> userCall = userapi.checklogin(Username);
        userCall.enqueue(new Callback<SignupResponse>() {
            @Override
            public void onResponse(@NonNull Call<SignupResponse> call,@NonNull Response<SignupResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "Code" + response.code(), Toast.LENGTH_LONG).show();
                    return;
                }
                Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                url.token += response.body().getToken();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(@NonNull Call<SignupResponse> call,@NonNull Throwable t) {
                Toast.makeText(LoginActivity.this, "error is = " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();

            }
        });

/*
        if(loginBLL.checkUser(username,password)){
            Log.e("usename not take ","this is msg");

            startActivity(new Intent(LoginActivity.this, MainActivity.class));
//            finish();
        }
        else {
            Toast.makeText(this, "Either username and password", Toast.LENGTH_LONG).show();
            etemail.requestFocus();
        }*/
    }
}
