package com.example.shoesapp.Presentation.Repository.Room;

import android.app.Application;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.example.shoesapp.Domain.Models.Item;
import com.example.shoesapp.Domain.RepositoryTask;
import com.example.shoesapp.Presentation.Repository.Model.ItemDTO;
import com.example.shoesapp.Presentation.Repository.Room.Dao.ItemDao;

import java.util.List;

public class ItemRepository implements RepositoryTask {
    private ItemDao mItemDao;
    private LiveData<List<ItemDTO>> mAllItems;
    public ItemRepository(Application application){
        ItemRoomDatabase db = ItemRoomDatabase.getDatabase(application);
        mItemDao = db.itemDao();
        mAllItems = mItemDao.getAllItems();
    }


    @Override
    public MutableLiveData<ItemDTO> findItem(String uid, LifecycleOwner owner) {
        return null;
    }

    @Override
    public LiveData<List<ItemDTO>> getAllItem() {
        return null;
    }

    @Override
    public void addItem(Item item) {

    }

    @Override
    public void deleteItem(Item item) {

    }

    @Override
    public void updateItem(Item item) {

    }
}
