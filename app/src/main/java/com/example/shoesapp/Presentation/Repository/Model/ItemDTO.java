package com.example.shoesapp.Presentation.Repository.Model;

import androidx.room.Entity;


import com.example.shoesapp.Domain.Models.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(tableName = "item", primaryKeys = {"id"}, ignoredColumns = {"sizes", "img", "description"})
public class ItemDTO extends Item {

}
