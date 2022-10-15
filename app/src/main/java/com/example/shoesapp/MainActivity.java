package com.example.shoesapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import com.example.shoesapp.DI.ServiceLocator;
import com.example.shoesapp.Domain.Models.Item;
import com.example.shoesapp.Presentation.Repository.Model.ItemDTO;
import com.example.shoesapp.View.ui.dashboard.DashboardFragment;
import com.example.shoesapp.View.ui.home.AddItemFragment;
import com.example.shoesapp.View.ui.home.HomeFragment;
import com.example.shoesapp.View.ui.notifications.NotificationsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.shoesapp.databinding.ActivityMainBinding;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public ActivityMainBinding binding;
    private NavController navController;
    List<ItemDTO> list;


    public NavController getNavController(){
        return navController;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ServiceLocator.getInstance().initBase(getApplication());
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();

        ItemDTO item1 = new ItemDTO();
        item1.setName("Nike Metcon 7");
        item1.setBground("#414045");
        item1.setPrice(5000.1f);
        item1.setImg(new ArrayList<>(Arrays.asList
                ("https://firebasestorage.googleapis.com/v0/b/nike-store-94e3e.appspot.com/o/nike-metcon-4.png?alt=media&token=cee42a27-176b-465d-b89a-9f94e9e21d5c",
                        "https://firebasestorage.googleapis.com/v0/b/nike-store-94e3e.appspot.com/o/nike-metcon-4.png?alt=media&token=cee42a27-176b-465d-b89a-9f94e9e21d5c",
                        "https://firebasestorage.googleapis.com/v0/b/nike-store-94e3e.appspot.com/o/nike-metcon-4.png?alt=media&token=cee42a27-176b-465d-b89a-9f94e9e21d5c")));
        item1.setImagesDTO(item1.imagesDTO);
        list.add(item1);
        item1.setImg(item1.img);

//        System.out.println(item1.getImg());
//        System.out.println(item1.getImages());
//        System.out.println(item1.imagesDTO);
//        List<String> img = new Gson().fromJson(item1.imagesDTO, List.class);
//        System.out.println(img.toString());
//        ServiceLocator.getInstance().getRepository().addItem(item1);
        ServiceLocator.getInstance().getRepository().getAllItem()
                .observe(this, new Observer<List<Item>>() {
                    @Override
                    public void onChanged(List<Item> itemList) {
//                        System.out.println(itemList.get(5).getImg());
                    }
                });

    }


}