package com.example.shoesapp.DI;

import android.app.Application;
import android.os.Build;

import com.example.shoesapp.Presentation.Repository.Model.DataModel;
import com.example.shoesapp.Presentation.Repository.network.vk.VK_API_Logic;
import com.example.shoesapp.domain.RepositoryTask;
import com.example.shoesapp.Presentation.Repository.Mock.Mock;
import com.example.shoesapp.Presentation.Repository.Room.ItemRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ServiceLocator {
    private static ServiceLocator instance = null;
    private Gson mGson;
    private VK_API_Logic mVK_API;
    private DataModel user;
    private ServiceLocator() {};

    public static ServiceLocator getInstance() {
        if (instance == null) {
            instance = new ServiceLocator();
        }
        return instance;
    }

    public Gson getGson() {
        if (mGson == null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                mGson = new GsonBuilder()
                        .registerTypeAdapter(
                                LocalDateTime.class,
                                (JsonDeserializer<LocalDateTime>) (json, typeOfT, context) -> LocalDateTime.parse(
                                        json.getAsString(),
                                        DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")
                                )
                        )
                        .registerTypeAdapter(
                                LocalDateTime.class,
                                (JsonSerializer<LocalDateTime>) (src, typeOfSrc, context) -> new JsonPrimitive(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm").format(src))
                        )
                        .create();
            }
        }
        return mGson;
    }

    private RepositoryTask mRepository;

    public void initBase(Application app){
        if(mRepository == null){
            mRepository = new ItemRepository(app);
        }
    }

    public RepositoryTask getRepository() {
        if (mRepository == null) {
            mRepository = new Mock();
        }
        return mRepository;
    }

    public VK_API_Logic getVK_API() {
        if (mVK_API == null) {
            mVK_API = new VK_API_Logic();
        }
        return mVK_API;
    }

    public DataModel getCurrentUser() {
        if (user == null) {
            user = new DataModel();
        }
        return user;
    }
}
