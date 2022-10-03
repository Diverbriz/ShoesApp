package com.example.shoesapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import com.example.shoesapp.View.ui.dashboard.DashboardFragment;
import com.example.shoesapp.View.ui.home.AddItemFragment;
import com.example.shoesapp.View.ui.home.HomeFragment;
import com.example.shoesapp.View.ui.notifications.NotificationsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.shoesapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public ActivityMainBinding binding;
    private NavController navController;

    public NavController getNavController(){
        return navController;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        binding.bottomNavView.setOnItemSelectedListener(item -> {
//            switch (item.getItemId()){
//                case R.id.navigation_home:
//                    replaceFragment(new HomeFragment());
//                    break;
//                case R.id.navigation_dashboard:
//                    replaceFragment(new DashboardFragment());
//                    break;
//                case R.id.navigation_notifications:
//                    replaceFragment(new NotificationsFragment());
//                    break;
//                case R.id.navigation_add:
//                    replaceFragment(new AddItemFragment());
//                    break;
//            }
//            return true;
//        });

//        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

//        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

//        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
//
//        if (navHostFragment != null) {
//
//            NavController navController = navHostFragment.getNavController();
//
//            AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                    R.id.navigation_home, R.id.navigation_dashboard,
//                    R.id.navigation_notifications, R.id.navigation_addItem)
//                    .build();
//
//            NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//            NavigationUI.setupWithNavController(binding.navView, navController);

//        }

    }

//    public void replaceFragment(Fragment fragment){
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.frame_layout, fragment);
//        fragmentTransaction.commit();
//    }
}