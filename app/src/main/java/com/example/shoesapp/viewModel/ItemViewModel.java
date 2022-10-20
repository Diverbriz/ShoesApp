package com.example.shoesapp.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.shoesapp.Presentation.Repository.Model.ItemDTO;

import java.util.ArrayList;
import java.util.List;

public class ItemViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    private ItemDTO item;
    private MutableLiveData<ItemDTO> liveData;
    private List<String> images;
    public ItemViewModel(){
        images = new ArrayList<>();
    }

    private MutableLiveData<ItemDTO> users;
    public LiveData<ItemDTO> getItemLiveData() {
        if (users == null) {
            users = new MutableLiveData<>();

        }
        return users;
    }




    public void setLiveData(MutableLiveData<ItemDTO> liveData) {
        this.liveData = liveData;
    }

    public ItemDTO getItem() {
        return item;
    }

    public void setItem(ItemDTO item) {
        this.item = item;
    }
}