package com.example.shoesapp.Presentation.Repository.network.retrofit.model;

import com.example.shoesapp.Presentation.Repository.Model.DataModel;
import com.example.shoesapp.Presentation.Repository.Model.Support;

import java.util.ArrayList;


public class UserModel {
    String page, per_page, total, total_pages;

    ArrayList<DataModel> data;
    private Support support;

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPer_page() {
        return per_page;
    }

    public void setPer_page(String per_page) {
        this.per_page = per_page;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(String total_pages) {
        this.total_pages = total_pages;
    }

    public ArrayList<DataModel> getData() {
        return data;
    }

    public void setData(ArrayList<DataModel> data) {
        this.data = data;
    }
}
