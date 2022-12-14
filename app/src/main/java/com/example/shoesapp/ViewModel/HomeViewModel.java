package com.example.shoesapp.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.shoesapp.Domain.Models.Item;
import com.example.shoesapp.Presentation.Repository.Mock.Mock;

import java.util.List;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private final LiveData<List<Item>> mItem;
    private Mock mock;
    public HomeViewModel() {
        mock = new Mock();
        mText = new MutableLiveData<>();
        mItem = mock.getAllItem();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<List<Item>> getItem() {
        return mItem;
    }
}