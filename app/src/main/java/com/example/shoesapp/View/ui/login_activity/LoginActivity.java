package com.example.shoesapp.View.ui.login_activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.shoesapp.R;
import com.example.shoesapp.View.adapters.LoginAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class LoginActivity extends AppCompatActivity {

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


    }
}