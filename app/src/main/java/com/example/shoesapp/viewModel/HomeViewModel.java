package com.example.shoesapp.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.shoesapp.DI.ServiceLocator;
import com.example.shoesapp.domain.RepositoryTask;
import com.example.shoesapp.Presentation.Repository.Mock.Mock;
import com.example.shoesapp.Presentation.Repository.Model.ItemDTO;

import java.util.List;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private final LiveData<List<ItemDTO>> mItem;
    private RepositoryTask mock;
    public HomeViewModel() {
        mock = ServiceLocator.getInstance().getRepository();
        mText = new MutableLiveData<>();
        mItem = mock.getAllItem();
        mText.setValue("This is home fragment");
    }

    public  Mock getMock() {
        return (Mock) mock;
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<List<ItemDTO>> getItem() {
        return mItem;
    }
}