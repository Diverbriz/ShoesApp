package com.example.shoesapp.Presentation.Repository.network;

import com.example.shoesapp.Presentation.Repository.Model.DataModel;
import com.example.shoesapp.Presentation.Repository.network.retrofit.model.User;
import com.example.shoesapp.Presentation.Repository.network.retrofit.model.UserModel;
import com.example.shoesapp.View.ui.login_activity.model.LoginResponse;
import com.example.shoesapp.View.ui.login_activity.model.Person;
import com.example.shoesapp.View.ui.login_activity.model.RegistrationResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Methods {
    @GET("api/users")
    Call<UserModel> getAllUsers(@Query("page") String page);

    @GET("api/users/{id}")
    Call<User> getOneUser(@Path("id") int id);

    @POST("api/registration")
    Call<RegistrationResponse> createPerson(@Body Person person);

    @POST("api/login")
    Call<LoginResponse> loginPerson(@Body Person person);
}
