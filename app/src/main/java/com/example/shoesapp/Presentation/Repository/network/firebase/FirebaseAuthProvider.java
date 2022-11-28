package com.example.shoesapp.Presentation.Repository.network.firebase;

import com.google.firebase.auth.FirebaseAuth;

public class FirebaseAuthProvider {
    private static FirebaseAuth mAuth;

    public static FirebaseAuth getmAuth(){
        if (mAuth == null){
            mAuth = FirebaseAuth.getInstance();
        }
        return mAuth;
    }


}
