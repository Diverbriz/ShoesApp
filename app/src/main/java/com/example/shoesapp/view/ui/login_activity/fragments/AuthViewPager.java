package com.example.shoesapp.view.ui.login_activity.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.shoesapp.R;
import com.example.shoesapp.databinding.ActivityLoginBinding;
import com.example.shoesapp.databinding.AuthViewpagerBinding;
import com.example.shoesapp.view.adapters.AuthAdapter;
import com.example.shoesapp.view.adapters.LoginAdapter;
import com.example.shoesapp.view.ui.login_activity.LoginActivity;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class AuthViewPager extends Fragment {
    private AuthAdapter authAdapter;
    private AuthViewpagerBinding mBinding;
    private ActivityLoginBinding loginBinding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = AuthViewpagerBinding.inflate(inflater, container, false);
//        loginBinding = ActivityLoginBinding.inflate(getLayoutInflater());
//        authAdapter = new AuthAdapter(this, loginBinding.tabLayout);
//        mBinding.viewPager.setAdapter(authAdapter);
//        new TabLayoutMediator(loginBinding.tabLayout, mBinding.viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
//            @Override
//            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
////                System.out.println(tab.getPosition());
//            }
//        }).attach();

        return mBinding.getRoot();
    }
}
