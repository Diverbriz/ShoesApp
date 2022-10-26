package com.example.shoesapp;

import android.os.Bundle;

import com.example.shoesapp.DI.ServiceLocator;
import com.example.shoesapp.domain.Models.Item;
import com.example.shoesapp.Presentation.Repository.Model.ItemDTO;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.navigation.NavController;

import com.example.shoesapp.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public ActivityMainBinding binding;

    private NavController navController;
    List<ItemDTO> list;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;
    public NavController getNavController(){
        return navController;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ServiceLocator.getInstance().initBase(getApplication());
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        drawerLayout = binding.drawerLayout;
        navigationView = binding.navView;
        toolbar = findViewById(R.id.toolbar_action);
        list = new ArrayList<>();

        /*
        * ToolBar
        * */
        setSupportActionBar(toolbar);

        /*
        * Navigation Drawer Menu
        * */
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout,
                toolbar,
                R.string.open,
                R.string.exit);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        ServiceLocator.getInstance().getRepository().getAllItem()
                .observe(this, new Observer<List<Item>>() {
                    @Override
                    public void onChanged(List<Item> itemList) {
//                        System.out.println(itemList.get(5).getImg());
                    }
                });
    }


}