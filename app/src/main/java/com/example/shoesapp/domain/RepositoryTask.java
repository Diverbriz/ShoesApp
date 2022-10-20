package com.example.shoesapp.domain;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.shoesapp.domain.Models.Item;

import java.util.List;

public interface RepositoryTask {
    <T extends Item> LiveData<List<T>> getAllItem();
   void addItem(Item item);
   void deleteItem(Item item);
   void updateItem(Item item);
    <T extends Item> MutableLiveData<T> findItem(String uid, LifecycleOwner owner);
}
