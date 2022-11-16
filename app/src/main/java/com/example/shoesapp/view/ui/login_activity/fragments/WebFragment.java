package com.example.shoesapp.view.ui.login_activity.fragments;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.shoesapp.databinding.WebFragmentBinding;



public class WebFragment extends Fragment {
    private WebFragmentBinding mBinding;
    private String url;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            url = getArguments().getString("url");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = WebFragmentBinding.inflate(inflater, container, false);
        Log.e(TAG, "Message " + url);
        if(url != null){
            CookieManager.getInstance().removeAllCookies(null);
            mBinding.Web.loadUrl(url);
        }

        return mBinding.getRoot();

    }
}
