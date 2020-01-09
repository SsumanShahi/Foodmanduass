package com.suman.foodmandu.ui.More;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.suman.foodmandu.DashboardActivity;
import com.suman.foodmandu.MainActivity;
import com.suman.foodmandu.R;
import com.suman.foodmandu.bill.LoginBLL;
import com.suman.foodmandu.model.username;
import com.suman.foodmandu.strictmode.StrictModeClass;

public class LoginActivity extends AppCompatActivity {

    private EditText etemail,etpassword;
    private Button btnlogin,btnfb,btngoogle;
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
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
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

        StrictModeClass.StrictMode();
        if(loginBLL.checkUser(username,password)){

            startActivity(new Intent(LoginActivity.this, MainActivity.class));
//            finish();
        }
        else {
            Toast.makeText(this, "Either username and password", Toast.LENGTH_LONG).show();
            etemail.requestFocus();
        }
    }
}
