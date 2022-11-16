package com.example.shoesapp.view.ui.login_activity.fragments;

import static android.content.ContentValues.TAG;
import static java.lang.System.in;
import static java.lang.System.out;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.shoesapp.MainActivity;
import com.example.shoesapp.databinding.RegistrationTabFragmentBinding;
import com.example.shoesapp.view.ui.login_activity.LoginActivity;
import com.example.shoesapp.view.ui.login_activity.model.Person;
import com.example.shoesapp.viewModel.loginViewModel.SignupViewModel;
import com.google.gson.Gson;

public class SignupTabFragment extends Fragment {
    private RegistrationTabFragmentBinding mBinding;
    private SignupViewModel mViewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = RegistrationTabFragmentBinding.inflate(getLayoutInflater(), container, false);
        mViewModel = new ViewModelProvider(this).get(SignupViewModel.class);
        mBinding.registrationButton.setOnClickListener(v -> {
            Person person = new Person();
            person.setEmail(mBinding.emailEdit.getText().toString());
            person.setPassword(mBinding.passwordEdit.getText().toString());

            mViewModel.addUser(person).observe(getViewLifecycleOwner(), user -> {
                out.println(user.getEmail() + "   " + user.getPassword());
                Gson gson = new Gson();

                Intent intent = new Intent(getContext(), MainActivity.class);
                intent.putExtra("profile", user.getEmail());
                startActivity(intent);
            });

        });
        return mBinding.getRoot();
    }
}
