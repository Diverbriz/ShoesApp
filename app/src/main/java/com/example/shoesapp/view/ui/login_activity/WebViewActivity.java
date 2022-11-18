package com.example.shoesapp.view.ui.login_activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.CookieManager;

import com.example.shoesapp.R;
import com.example.shoesapp.databinding.ActivityWebViewBinding;

public class WebViewActivity extends AppCompatActivity {
    private ActivityWebViewBinding mBinding;
    private String url = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityWebViewBinding.inflate(getLayoutInflater());
        if(getIntent().getExtras().get("url") != null){
            url = getIntent().getExtras().get("url").toString();

        }
        else {
            url = "https://oauth.vk.com/authorize?client_id=51479013&redirect_uri=https://oauth.vk.com/blank.html&display=mobile";

        }
        mBinding.webView.loadUrl(url);
        setContentView(mBinding.getRoot());

        CookieManager.getInstance().setAcceptThirdPartyCookies(mBinding.webView, true);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}