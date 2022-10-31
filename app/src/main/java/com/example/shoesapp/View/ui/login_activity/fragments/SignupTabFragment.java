package com.example.shoesapp.View.ui.login_activity.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.shoesapp.databinding.RegistrationTabFragmentBinding;
import com.example.shoesapp.viewModel.loginViewModel.SignupViewModel;

public class SignupTabFragment extends Fragment {
    private RegistrationTabFragmentBinding mBinding;
    private SignupViewModel mViewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = RegistrationTabFragmentBinding.inflate(getLayoutInflater(), container, false);
        mViewModel = new ViewModelProvider(this).get(SignupViewModel.class);


        return mBinding.getRoot();
    }
}
