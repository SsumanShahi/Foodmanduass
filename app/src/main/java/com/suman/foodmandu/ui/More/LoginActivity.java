package com.suman.foodmandu.ui.More;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.suman.foodmandu.R;

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
    }
}
