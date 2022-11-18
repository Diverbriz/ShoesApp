package com.example.shoesapp.view.ui.login_activity;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.shoesapp.R;
import com.example.shoesapp.databinding.ActivityLoginBinding;
import com.example.shoesapp.databinding.AuthViewpagerBinding;
import com.example.shoesapp.databinding.WebFragmentBinding;
import com.example.shoesapp.view.adapters.AuthAdapter;
import com.example.shoesapp.view.adapters.LoginAdapter;
import com.example.shoesapp.view.ui.login_activity.fragments.LoginTabFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private String urlVkOauth = "https://oauth.vk.com/authorize?client_id=51479013&redirect_uri=https://oauth.vk.com/blank.html&display=mobile";

    private WebFragmentBinding webBinding;
//    private ViewPager2 viewPager2;
    private ActivityLoginBinding mBinding;
//    private FragmentStateAdapter pagerAdapter;
    private AuthAdapter authAdapter;
    private AuthViewpagerBinding authBinding;
    private FloatingActionButton fab_google, fab_vk, fab_gmail;
//    private NavController navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        authBinding = AuthViewpagerBinding.inflate(getLayoutInflater());

        webBinding = WebFragmentBinding.inflate(getLayoutInflater());


        setContentView(mBinding.getRoot());

//        viewPager2 = findViewById(R.id.view_pager);



        mBinding.tabLayout.addTab(mBinding.tabLayout.newTab().setText("Login"));
        mBinding.tabLayout.addTab(mBinding.tabLayout.newTab().setText("SignUp"));


        mBinding.tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        authAdapter = new AuthAdapter(this, mBinding.tabLayout);
        mBinding.viewPager.setAdapter(authAdapter);

        new TabLayoutMediator(mBinding.tabLayout, mBinding.viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        if(position == 0){
                            tab.setText("Login");
                        }
                        else {
                            tab.setText("SignUp");
                        }
                    }
                }).attach();
//        mBinding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
////                switch (tab.getPosition()){
////                    case 0:
////                        System.out.println(tab.getPosition());
////
////                        Navigation.findNavController(mBinding.navHostFragment).
////                                navigate(R.id.action_global_loginTabFragment2);
////                    case 1:
////                        System.out.println(tab.getPosition());
////                        Navigation.findNavController(mBinding.navHostFragment).
////                                navigate(R.id.action_global_signupTabFragment);
////                }
////                System.out.println(tab.getPosition());
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//                System.out.println("Tab unselected" + tab.getPosition());
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//                System.out.println("Tab reselected" + tab.getPosition());
//            }
//        });



        mBinding.fabVk.setOnClickListener(this);
        mBinding.fabFirebase.setOnClickListener(this);
        mBinding.fabGmail.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fab_firebase:
                Log.e(TAG, "Лог для Google провайдера ");

//                Intent intent = new Intent(
//                        Intent.ACTION_VIEW,
//                        Uri.parse("https://oauth.vk.com/authorize?client_id=7975999&scope=email&redirect_uri=https://oauth.vk.com/blank.html&display=mobile&response_type=token&scope=offline, email"));
//                startActivity(intent);
                break;
            case R.id.fab_vk:
                Log.e(TAG, "Лог для Vk провайдера ");
//                Bundle bundle = new Bundle();
//                        bundle.putString("url", urlVkOauth);
                                //                webBinding.Web.loadUrl(bundle.getString("url"));
//                        Navigation.findNavController(mBinding.navHostFragment)
//                            .navigate(R.id.action_global_webView, bundle);
//51479013 client_id ShoeApp (7975999)
                // создание объекта Intent для запуска SecondActivity
                Intent intent = new Intent(this, WebViewActivity.class);
// передача объекта с ключом "hello" и значением "Hello World"
                intent.putExtra("url", urlVkOauth);
// запуск SecondActivity
                startActivity(intent);
                break;
            case R.id.fab_gmail:
                Log.e(TAG, "Лог для Gmail провайдера ");
                break;
        }
    }

    public void vkAuth(){
        Bundle bundle = new Bundle();

        bundle.putString("url",
                "https://oauth.vk.com/authorize?client_id=51476535&redirect_uri=https://oauth.vk.com/blank.html&display=mobile");

    }
}