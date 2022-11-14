package com.example.shoesapp.View.ui.login_activity;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.shoesapp.R;
import com.example.shoesapp.View.adapters.LoginAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private FragmentStateAdapter pagerAdapter;
    private FloatingActionButton fab_google, fab_vk, fab_gmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tabLayout = findViewById(R.id.tab_layout);
        viewPager2 = findViewById(R.id.view_pager);

        fab_google = findViewById(R.id.fab_google);
        fab_vk = findViewById(R.id.fab_vk);
        fab_gmail = findViewById(R.id.fab_gmail);

        tabLayout.addTab(tabLayout.newTab().setText("Login"));
        tabLayout.addTab(tabLayout.newTab().setText("SignUp"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        pagerAdapter = new LoginAdapter(this, tabLayout.getTabCount());

        viewPager2.setAdapter(pagerAdapter);
        new TabLayoutMediator(tabLayout, viewPager2,
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
        fab_vk.setOnClickListener(this);
        fab_google.setOnClickListener(this);
        fab_gmail.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fab_google:
                Log.e(TAG, "Лог для Google провайдера ");
                break;
            case R.id.fab_vk:
                Log.e(TAG, "Лог для Vk провайдера ");
                break;
            case R.id.fab_gmail:
                Log.e(TAG, "Лог для Gmail провайдера ");
                break;
        }
    }
}