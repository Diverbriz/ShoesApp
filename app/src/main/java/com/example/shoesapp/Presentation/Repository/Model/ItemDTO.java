package com.example.shoesapp.Presentation.Repository.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;


import com.example.shoesapp.Domain.Models.Item;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(tableName = "item", primaryKeys = {"id"}, ignoredColumns = {"sizes", "img", "description"})
public class ItemDTO extends Item {
    @ColumnInfo
    public String imagesDTO;
    public static ItemDTO convertFromItem(Item item) {
        ItemDTO itemDTO = new ItemDTO();

        itemDTO.setId(item.getId());
        itemDTO.setName(item.getName());
        itemDTO.setPrice(item.getPrice());
        itemDTO.setImg(item.getImg());
        itemDTO.setSizes(item.getSizes());
        itemDTO.setBground(item.getBground());
        itemDTO.setDescription(item.getDescription());
        return itemDTO;
    }
    public void setImagesDTO(String imagesDTO) {
        this.imagesDTO = imagesDTO;
        super.setImg(new Gson().fromJson(this.imagesDTO, List.class));
    }

    public List<String> getImages() {
        if (super.getImg() == null || super.getImg().isEmpty()) {
            super.setImg(new Gson().fromJson(this.imagesDTO, List.class));
        }
        return super.getImg();
    }

    @Override
    public void setImg(List<String> img) {
        super.setImg(img);
        this.imagesDTO = new Gson().toJson(img);
    }


}
