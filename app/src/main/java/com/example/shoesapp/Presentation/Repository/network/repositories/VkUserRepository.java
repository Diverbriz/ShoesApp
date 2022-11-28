package com.example.shoesapp.Presentation.Repository.network.repositories;

public class VkUserRepository {
    private static VkUserRepository userRepository;

    public static VkUserRepository getInstance(){
        if(userRepository == null){
            userRepository = new VkUserRepository();
        }

        return userRepository;
    }


}
