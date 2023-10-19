package com.example.mvvmjava.data.remote;

import com.example.mvvmjava.data.model.MobileResponse;

import retrofit2.Call;
import retrofit2.http.GET;
public interface APIService {
    @GET("/api/mobile/post")
    Call<MobileResponse> getMobiles();
}
