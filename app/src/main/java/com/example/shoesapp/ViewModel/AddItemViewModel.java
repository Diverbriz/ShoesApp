package com.example.shoesapp.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.shoesapp.DI.ServiceLocator;
import com.example.shoesapp.Domain.Models.Item;

import java.util.Arrays;
import java.util.List;

public class AddItemViewModel extends ViewModel {
    public void AddParty(String name,
                         float price,
                         String description,
                         List<String> img){
        int MaxPeopleCount = 0;
        Item item = new Item();
        item.setName(name);
        item.setPrice(price);
        item.setDescription(Arrays.asList(description));
        item.setImg(img);
        ServiceLocator.getInstance().getRepository().addItem(item);
    }
}