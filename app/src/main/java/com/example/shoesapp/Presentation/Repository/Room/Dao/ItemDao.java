package com.example.shoesapp.Presentation.Repository.Room.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.shoesapp.Presentation.Repository.Model.ItemDTO;

import java.util.List;

@Dao
public interface ItemDao {
    @Insert
    void addItem(ItemDTO item);

    @Delete
    void deleteItem(ItemDTO item);

    @Query("SELECT * FROM item")
    LiveData<List<ItemDTO>> getAllItems();
}
