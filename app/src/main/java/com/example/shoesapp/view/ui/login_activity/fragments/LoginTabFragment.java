package com.example.shoesapp.view.ui.login_activity.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.shoesapp.databinding.LoginTabFragmentBinding;
import com.example.shoesapp.viewModel.loginViewModel.LoginViewModel;

public class LoginTabFragment extends Fragment {
    private LoginTabFragmentBinding mBinding;
    private LoginViewModel mViewModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = LoginTabFragmentBinding.inflate(getLayoutInflater(), container, false);
        mViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        return mBinding.getRoot();
    }
}
