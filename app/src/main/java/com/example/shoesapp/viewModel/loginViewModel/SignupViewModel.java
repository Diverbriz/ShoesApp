package com.example.shoesapp.viewModel.loginViewModel;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.shoesapp.Presentation.Repository.Model.DataModel;
import com.example.shoesapp.Presentation.Repository.Model.Support;
import com.example.shoesapp.Presentation.Repository.network.Methods;
import com.example.shoesapp.Presentation.Repository.network.RetrofitClient;
import com.example.shoesapp.Presentation.Repository.network.repositories.UserRepository;
import com.example.shoesapp.Presentation.Repository.network.retrofit.model.UserModel;
import com.example.shoesapp.view.ui.login_activity.model.Person;
import com.example.shoesapp.view.ui.login_activity.model.RegistrationResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupViewModel extends ViewModel {

    private RegistrationResponse token;
    private MutableLiveData<RegistrationResponse> responseReg = new MutableLiveData<>();
    private Methods methods = RetrofitClient.createService(Methods.class);
    public void getAllUsers(){
        Call<UserModel> call = methods.getAllUsers("2");
        call.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(@NonNull Call<UserModel> call, @NonNull Response<UserModel> response) {
                Log.e(TAG, "On Response code: " + call.request());

                ArrayList<DataModel> dataModels = response.body().getData();
                Support support = response.body().getSupport();

                Log.e(TAG, "On Response data:" + support.toString());

                Log.e(TAG, "On Response data:"+"\n\n\n" + response.body());
                for (DataModel data1: dataModels
                ) {
                    Log.e(TAG, "On Response data:" + data1.getEmail());
                }

            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                Log.e(TAG, "On Error Response data:" + call.request());
            }
        });

    }

    public LiveData<RegistrationResponse> getResponse(){
            return responseReg;
    }

    public LiveData<RegistrationResponse> addUser(Person person){
         return UserRepository.getInstance().createPerson(person);
    }


    public RegistrationResponse getToken() {
        return token;
    }

    public void setToken(RegistrationResponse token) {
        this.token = token;
    }
}
