package com.example.shoesapp.view.ui.login_activity.model;

import com.google.gson.annotations.SerializedName;

public class Person {
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;
    public Person(){}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
