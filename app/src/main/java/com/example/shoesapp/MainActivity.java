package com.example.shoesapp;

import static java.lang.System.out;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;


import com.example.shoesapp.DI.ServiceLocator;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;

import com.example.shoesapp.Presentation.Repository.network.vk.VK_API_Logic;
import com.example.shoesapp.databinding.ActivityMainBinding;
import com.example.shoesapp.view.ui.login_activity.LoginActivity;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    public ActivityMainBinding binding;
    private DrawerLayout drawerLayout;
    private NavController navController;
    public NavController getNavController(){
        return navController;
    }
    private String token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ServiceLocator.getInstance().initBase(getApplication());
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                binding.drawerLayout,
                binding.toolbar,
                R.string.navigation_open,
                R.string.navigation_close
        );
        toggle.syncState();

//        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                drawerLayout.bringToFront();
//                drawerLayout.clearFocus();
//                drawerLayout.openDrawer(GravityCompat.START);
//            }
//        });
//        navigationView = binding.navView;
        if(getIntent().getExtras() != null){
            Bundle arg = getIntent().getExtras();
            out.println(arg.get("token").toString());
            token = arg.get("token").toString();
            ServiceLocator.getInstance().getVK_API()
                    .getProfile(token, this);
        }


    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.navigation_home_graph:
                out.println("Home");
                break;
            case R.id.navigation_profile:
                Intent myIntent = new Intent(MainActivity.this,
                        LoginActivity.class);
                startActivity(myIntent);
                break;
        }
        return true;
    }
}