package com.suman.foodmandu.ui.More;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.suman.foodmandu.R;

public class SignupActivity extends AppCompatActivity {


    private EditText etfirstname,etlastname,etphone,etemail,etpassword,etcnpassword;
    private Button btnsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        etfirstname = findViewById(R.id.etfirstname);
        etlastname = findViewById(R.id.etlastname);
        etphone = findViewById(R.id.etphone);
        etemail = findViewById(R.id.etemail);
        etpassword = findViewById(R.id.etpassword);
        etcnpassword = findViewById(R.id.etcnpassword);
        btnsignup = findViewById(R.id.btnsignup);
    }
}
