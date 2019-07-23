package com.rplsnapan.e_attendance.activities;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.rplsnapan.e_attendance.R;
import com.rplsnapan.e_attendance.apihelper.ApiClient;
import com.rplsnapan.e_attendance.models.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etUsername, etPassword;
    private Button btLogin;
    RelativeLayout relativeLayout;
    AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Ini Background Animasi
//        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
//        animationDrawable = (AnimationDrawable) relativeLayout.getBackground();
//        animationDrawable.setEnterFadeDuration(3000);
//        animationDrawable.setExitFadeDuration(1500);


        etUsername = findViewById(R.id.edt_loginusername);
        etPassword = findViewById(R.id.edt_loginpassword);

        findViewById(R.id.btn_login).setOnClickListener(this);

    }

//    protected void onPause() {
//        super.onPause();
//
//        if (animationDrawable != null && !animationDrawable.isRunning()) {
//            animationDrawable.stop();
//        }
//    }
//    protected void onResume(){
//        super.onResume();
//
//        if (animationDrawable != null && animationDrawable.isRunning()){
//            animationDrawable.start();
//        }
//    }

    private void userLogin() {
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (username.isEmpty()) {
            Toast.makeText(this, "Username is wrong!!", Toast.LENGTH_SHORT).show();
        }
        if (password.isEmpty()) {
            Toast.makeText(this, "Password is wrong!!", Toast.LENGTH_SHORT).show();
        }

        Call<LoginResponse> call = ApiClient.getInstance().getApi().userLogin(username, password);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();

                if (loginResponse.getStatus()==200){

                    Toast.makeText(LoginActivity.this, loginResponse.getMessage(), Toast.LENGTH_LONG).show();

                }else {
                    Toast.makeText(LoginActivity.this, loginResponse.getMessage(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                userLogin();
                break;
        }
    }

}
