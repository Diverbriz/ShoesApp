package com.example.shoesapp.Presentation.Repository.network.vk;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface VK_API {
    @GET("users.get")
    Call<UserResponse> getUserInfo(@QueryMap Map<String, String> api_info,
                                   @Query("access_token") String access_token);
}
