package com.example.shoesapp.Presentation.Repository.network.vk;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.navigation.Navigation;

import com.example.shoesapp.DI.ServiceLocator;
import com.example.shoesapp.MainActivity;
import com.example.shoesapp.Presentation.Repository.Model.DataModel;
import com.example.shoesapp.view.ui.login_activity.WebViewActivity;

import java.net.URISyntaxException;

public class VK_Oauth {
    private String TAG = "Token response: ";

    public void auth(MainActivity activity) {
        Bundle bundle = new Bundle();
        bundle.putString("url", "https://oauth.vk.com/authorize?client_id=51479013&scope=email&redirect_uri=https://oauth.vk.com/blank.html&display=mobile&response_type=token&scope=offline, email");

//        Intent intent = new Intent(activity, WebViewActivity.class);
//
//        intent.putExtra("url", "\"https://oauth.vk.com/authorize?" +
//                "client_id=51479013&scope=email" +
//                "&redirect_uri=https://oauth.vk.com/blank.html" +
//                "&display=mobile" +
//                "&response_type=token&scope=offline, email\"");
//        Navigation.findNavController(activity.mBinding.navHostFragment).navigate(R.id.action_authFragment_to_webFragment, bundle);
    }
    public WebViewClient oauth2Vk(WebViewActivity activity){
        return new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

                if(request.getUrl().toString().contains("https://oauth.vk.com/blank.html#")){
                    String token = Uri.parse(request.getUrl().toString().replace("#", "?")).getQueryParameter("access_token");
                    String email = Uri.parse(request.getUrl().toString().replace("#", "?")).getQueryParameter("email");
                    Log.e(TAG, "Access token " + email);
                    DataModel user = ServiceLocator.getInstance().getCurrentUser();
                    user.setId(token);
                    user.setEmail(email);
                    if(token != null){
                        Intent intent = new Intent(activity, MainActivity.class);
                        intent.putExtra("token", token);

                        activity.startActivity(intent);
                    }
                    return false;
                }
                view.loadUrl(request.getUrl().toString());
                return true;
            }
        };
    }

}
