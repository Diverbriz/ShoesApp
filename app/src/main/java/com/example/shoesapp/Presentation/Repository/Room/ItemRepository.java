package com.example.shoesapp.Presentation.Repository.Room;

import android.app.Application;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.example.shoesapp.domain.Models.Item;
import com.example.shoesapp.domain.RepositoryTask;
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


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public MutableLiveData<ItemDTO> findItem(String uid, LifecycleOwner owner) {

        MutableLiveData<ItemDTO> specificItem = new MutableLiveData<>();

        mAllItems.observe(owner, (List<ItemDTO> items)->{
            specificItem.setValue(items.stream()
                    .filter(itemDTO -> uid.equals(itemDTO.getId()))
                    .findAny()
                    .orElse(null)
            );
        });
        return specificItem;
    }

    @Override
    public LiveData<List<ItemDTO>> getAllItem() {

        return mAllItems;
    }

    @Override
    public void addItem(Item item) {
        ItemDTO itemDTO = ItemDTO.convertFromItem(item);

        ItemRoomDatabase.databaseWriteExecutor.execute(() -> {
            mItemDao.addItem(itemDTO);
        });
    }

    @Override
    public void deleteItem(Item item) {
        ItemDTO itemDTO = ItemDTO.convertFromItem(item);

        ItemRoomDatabase.databaseWriteExecutor.execute(() -> {
            mItemDao.deleteItem(itemDTO);
        });

    }

    @Override
    public void updateItem(Item item) {

    }
}
