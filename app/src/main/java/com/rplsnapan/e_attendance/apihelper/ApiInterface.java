package com.rplsnapan.e_attendance.apihelper;

import com.rplsnapan.e_attendance.models.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("attendance/login")
    Call <LoginResponse> userLogin(
            @Field("username") String username,
            @Field("password") String password);
}