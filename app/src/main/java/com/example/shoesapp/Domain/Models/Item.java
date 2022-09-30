package com.example.shoesapp.Domain.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Item {

    private String id;
    private String name;
    private float price;
    private List<Float> sizes;
    private String bground;
    private List<String> img;
    private List<String> description;

    public Item() {
        id = UUID.randomUUID().toString();
        img = new ArrayList<>();
        description = new ArrayList<>();
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<Float> getSizes() {
        return sizes;
    }

    public void setSizes(List<Float> sizes) {
        this.sizes = sizes;
    }

    public String getBground() {
        return bground;
    }

    public void setBground(String bground) {
        this.bground = bground;
    }

    public List<String> getImg() {
        return img;
    }

    public void setImg(List<String> img) {
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getDescription() {
        return description;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }
}
