package com.example.shoesapp.Presentation.Repository.network.retrofit.model;

import com.example.shoesapp.Presentation.Repository.Model.DataModel;
import com.example.shoesapp.Presentation.Repository.Model.Support;
import com.google.gson.annotations.SerializedName;

public class User {
    private DataModel data;
    private Support support;

    public DataModel getData() {
        return data;
    }

    public void setData(DataModel data) {
        this.data = data;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }
}
