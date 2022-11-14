package com.example.shoesapp.View.ui.login_activity.fragments;

import static android.content.ContentValues.TAG;
import static java.lang.System.out;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.shoesapp.View.ui.login_activity.model.Person;
import com.example.shoesapp.databinding.RegistrationTabFragmentBinding;
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
            out.println(person.getEmail() + "   " + person.getPassword());

            mViewModel.addUser(person).observe(getViewLifecycleOwner(), user -> {

                Log.e(TAG, "Ne Error " + user.getEmail());
            });

        });
        return mBinding.getRoot();
    }
}
