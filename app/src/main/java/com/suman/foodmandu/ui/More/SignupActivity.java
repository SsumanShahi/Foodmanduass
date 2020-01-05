package com.suman.foodmandu.ui.More;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.CursorLoader;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.suman.foodmandu.R;
import com.suman.foodmandu.Url.url;
import com.suman.foodmandu.api.Userapi;
import com.suman.foodmandu.model.User;
import com.suman.foodmandu.serverresponse.ImageResponse;
import com.suman.foodmandu.serverresponse.SignupResponse;
import com.suman.foodmandu.strictmode.StrictModeClass;

import java.io.File;
import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {

    private CircleImageView img;
    private EditText etfirstname,etlastname,etphone,etemail,etpassword,etcnpassword;
    private Button btnsignup;
    private String imagePath;
    private String imageName="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        img = findViewById(R.id.img);
        etfirstname = findViewById(R.id.etfirstname);
        etlastname = findViewById(R.id.etlastname);
        etphone = findViewById(R.id.etphone);
        etemail = findViewById(R.id.etemail);
        etpassword = findViewById(R.id.etpassword);
        etcnpassword = findViewById(R.id.etcnpassword);
        btnsignup = findViewById(R.id.btnsignup);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                browseimage();
            }
        });

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etpassword.getText().toString().equals((etcnpassword.getText().toString()))){
                    if(validate()){
                        saveImageOnly();
                        signup();
                    }
                }else
                {
                    Toast.makeText(SignupActivity.this, "Password does not match", Toast.LENGTH_LONG).show();
                    etpassword.requestFocus();
                    return;

                }
            }
        });

    }

    private void signup() {
        String fname = etfirstname.getText().toString();
        String lname = etlastname.getText().toString();
        String phone = etphone.getText().toString();
        String username = etemail.getText().toString();
        String password = etpassword.getText().toString();

        User user = new User(fname,lname,phone,username,password,imageName);

        Userapi userapi = url.getInstance().create(Userapi.class);
        Call<SignupResponse> signupResponseCall = userapi.registerUser(user);

        signupResponseCall.enqueue(new Callback<SignupResponse>() {
            @Override
            public void onResponse(Call<SignupResponse> call, Response<SignupResponse> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(SignupActivity.this, "Code"+response.code(), Toast.LENGTH_LONG).show();
                    return;
                }
                Toast.makeText(SignupActivity.this, "Registered", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<SignupResponse> call, Throwable t) {
                Toast.makeText(SignupActivity.this, "Error"+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

    private void saveImageOnly() {
        File file = new File(imagePath);
        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"),file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("myFile",
                file.getName(),requestBody);

        Userapi userapi = url.getInstance().create(Userapi.class);
        Call<ImageResponse> responseBodyCall = userapi.uploadImage(body);

        StrictModeClass.StrictMode();
        //Synchronomus method

        try{
            Response<ImageResponse> imageResponseResponse = responseBodyCall.execute();
            imageName = imageResponseResponse.body().getFilename();
            Toast.makeText(this, "Image Inserted", Toast.LENGTH_LONG).show();
        }catch (IOException e)
        {
            Toast.makeText(this, "Error"+e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    private void browseimage() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if(data == null)
            {
                Toast.makeText(this, "Please select an image", Toast.LENGTH_LONG).show();
            }
        }

        Uri uri = data.getData();
        img.setImageURI(uri);
        imagePath = getRealPathFromUri(uri);
    }

    private String getRealPathFromUri(Uri uri) {

        String[] projection = {MediaStore.Images.Media.DATA};
        CursorLoader loader = new CursorLoader(getApplicationContext(),uri,projection, null
                ,null,null);
        Cursor cursor = loader.loadInBackground();
        int colIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String result = cursor.getString(colIndex);
        cursor.close();
        return result;
    }

    private boolean validate() {
        boolean status = true;
        if(etemail.getText().toString().length()<6)
        {
            etemail.setError("minimum 6 character");
            status=false;
        }
        return status;
    }
}
