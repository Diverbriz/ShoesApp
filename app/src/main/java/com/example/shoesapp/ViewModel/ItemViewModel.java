package com.example.shoesapp.ViewModel;

import androidx.lifecycle.ViewModel;

import com.example.shoesapp.Domain.Models.Item;

public class ItemViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    private Item item;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}