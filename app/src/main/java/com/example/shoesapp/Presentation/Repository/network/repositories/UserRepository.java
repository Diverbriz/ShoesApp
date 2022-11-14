package com.example.shoesapp.Presentation.Repository.network.repositories;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.shoesapp.MainActivity;
import com.example.shoesapp.Presentation.Repository.network.Methods;
import com.example.shoesapp.Presentation.Repository.network.RetrofitClient;
import com.example.shoesapp.Presentation.Repository.network.retrofit.model.UserModel;
import com.example.shoesapp.View.ui.login_activity.LoginActivity;
import com.example.shoesapp.View.ui.login_activity.model.LoginResponse;
import com.example.shoesapp.View.ui.login_activity.model.Person;
import com.example.shoesapp.View.ui.login_activity.model.RegistrationResponse;
import com.google.gson.Gson;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {
    private static UserRepository userRepository;

    public static UserRepository getInstance(){
        if(userRepository == null){
            userRepository = new UserRepository();
        }

        return userRepository;
    }

    private Methods usersApi;

    public UserRepository(){
        usersApi = RetrofitClient.createService(Methods.class);
    }

    public MutableLiveData<UserModel> getAllUser(String page){
        MutableLiveData<UserModel> usersData = new MutableLiveData<>();
        usersApi.getAllUsers(page).enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                if(response.isSuccessful()){
                    usersData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                    usersData.setValue(null);
            }
        });
        return usersData;
    }

    public MutableLiveData<RegistrationResponse> synchronizedCreatePerson(Person person) throws IOException {
        try
        {
            Response<RegistrationResponse> response = usersApi.createPerson(person).execute();
            MutableLiveData<RegistrationResponse> apiResponse = new MutableLiveData<>();
            apiResponse.setValue(response.body());

            //API response
            System.out.println(apiResponse);
            return apiResponse;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }

    public MutableLiveData<RegistrationResponse> createPerson(Person person){
        MutableLiveData<RegistrationResponse> callMutable = new MutableLiveData<>();

        usersApi.createPerson(person).enqueue(new Callback<RegistrationResponse>() {
            @Override
            public void onResponse(Call<RegistrationResponse> call, Response<RegistrationResponse> response) {
               if(response.isSuccessful()){
                   Log.e(TAG, "Response of post call " + call.request());
                   callMutable.postValue(response.body());
                   Log.e(TAG, "Response of post call " + response.body());
                   if (callMutable.getValue() != null){
                       Log.e(TAG, "-------------");
                       Gson gson = new Gson();
                       String jsonResponse = gson.toJson(callMutable.getValue());

                       Log.e(TAG, "-------------" + jsonResponse);
                   }
               }
            }

            @Override
            public void onFailure(Call<RegistrationResponse> call, Throwable t) {
                Log.e(TAG, "Error response "+ t.getMessage());
                callMutable.setValue(null);
            }
        });
        return callMutable;
    }

    public MutableLiveData<String> loginPerson(Person person){
        MutableLiveData<String> token = new MutableLiveData<>();
        usersApi.loginPerson(person).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                Log.i(TAG, "Response of post call " + call.request());
                token.setValue(response.body().getToken());
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.e(TAG, "Response Error " + t.getMessage());
                token.setValue(null);
            }
        });
        return token;
    }
}
