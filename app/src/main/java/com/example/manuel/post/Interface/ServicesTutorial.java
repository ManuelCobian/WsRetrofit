package com.example.manuel.post.Interface;

import com.example.manuel.post.Model.ResponseService;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by manuel on 01/04/2018.
 */

public interface ServicesTutorial {
    @GET("usersFake")
    Call<List<ResponseService>>getUserGet();

    @POST("usersFake")
    Call<List<ResponseService>>getUserPost();
}
