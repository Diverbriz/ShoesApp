package com.example.shoesapp;

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
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.shoesapp.View.ui.login.LoginFragment;
import com.example.shoesapp.View.ui.login_activity.LoginActivity;
import com.example.shoesapp.databinding.ActivityMainBinding;
import com.example.shoesapp.databinding.AddImageElementBinding;
import com.example.shoesapp.databinding.FragmentAddItemBinding;
import com.example.shoesapp.databinding.NavHeaderBinding;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    public ActivityMainBinding binding;
    private DrawerLayout drawerLayout;
    private NavController navController;
    public NavController getNavController(){
        return navController;
    }

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
                System.out.println("Home");
                break;
            case R.id.navigation_profile:
//                getSupportFragmentManager().beginTransaction().replace(
//                        R.id.frame_layout,
//                        new LoginFragment()
//                ).commit();

                Intent myIntent = new Intent(MainActivity.this,
                        LoginActivity.class);
                 //Optional parameters
                MainActivity.this.startActivity(myIntent);

                break;
        }
        return true;
    }
}