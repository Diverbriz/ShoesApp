package com.example.shoesapp.viewModel;

import android.os.Build;

import androidx.lifecycle.ViewModel;

import com.example.shoesapp.DI.ServiceLocator;
import com.example.shoesapp.Presentation.Repository.Model.ItemDTO;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AddItemViewModel extends ViewModel {
    public void AddItem(String name,
                         float price,
                         String description,
                         List<String> img){
        int MaxPeopleCount = 0;
        ItemDTO item = new ItemDTO();
        item.setName(name);
        item.setPrice(price);
        item.setDescription(Arrays.asList(description));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            item.setImg(img.stream().filter(Objects::nonNull).collect(Collectors.toList()));
        }
        System.out.println("Add Item Images " + item.getImages());
        ServiceLocator.getInstance().getRepository().addItem(item);
    }
}