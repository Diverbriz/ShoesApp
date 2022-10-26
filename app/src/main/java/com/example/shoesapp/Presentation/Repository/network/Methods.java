package com.example.shoesapp.Presentation.Repository.network;

import com.example.shoesapp.Presentation.Repository.Model.DataModel;
import com.example.shoesapp.Presentation.Repository.network.retrofit.model.User;
import com.example.shoesapp.Presentation.Repository.network.retrofit.model.UserModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Methods {
    @GET("api/users?page=2")
    Call<UserModel> getAllUsers();

    @GET("api/users/{id}")
    Call<User> getOneUser(@Path("id") int id);

    @POST("api/users")
    Call<UserModel> createUser(@Body UserModel userModel);
}
