package com.example.shoesapp.Presentation.Repository.network.vk;

import android.os.Bundle;

import androidx.navigation.Navigation;

import com.example.shoesapp.MainActivity;

public class VK_Oauth {
    public void auth(MainActivity activity) {
        Bundle bundle = new Bundle();
        bundle.putString("url", "https://oauth.vk.com/authorize?client_id=7975999&scope=email&redirect_uri=https://oauth.vk.com/blank.html&display=mobile&response_type=token&scope=offline, email");

//        Navigation.findNavController(activity.mBinding.navHostFragment).navigate(R.id.action_authFragment_to_webFragment, bundle);
    }
}
