package com.example.shoesapp.Presentation.Repository.Room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.shoesapp.Presentation.Repository.Model.ItemDTO;
import com.example.shoesapp.Presentation.Repository.Room.Dao.ItemDao;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {ItemDTO.class}, version = 1)
public abstract class ItemRoomDatabase extends RoomDatabase {
    public abstract ItemDao itemDao();

    private static volatile ItemRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static ItemRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ItemRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    ItemRoomDatabase.class, "itemRoom_database")
//                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}