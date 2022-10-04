package com.example.shoesapp.DI;

import com.example.shoesapp.Domain.RepositoryTask;
import com.example.shoesapp.Presentation.Repository.Mock.Mock;

public class ServiceLocator {
    private static ServiceLocator instance = null;

    private ServiceLocator() {};

    public static ServiceLocator getInstance() {
        if (instance == null) {
            instance = new ServiceLocator();
        }
        return instance;
    }
    private RepositoryTask mRepository;

    public RepositoryTask getRepository() {
        if (mRepository == null) {
            mRepository = new Mock();
        }
        return mRepository;
    }
}
