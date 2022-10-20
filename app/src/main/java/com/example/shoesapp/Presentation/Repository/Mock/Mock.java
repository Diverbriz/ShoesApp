package com.example.shoesapp.Presentation.Repository.Mock;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;

import com.example.shoesapp.domain.Models.Item;
import com.example.shoesapp.domain.RepositoryTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mock implements RepositoryTask {

    MutableLiveData<List<Item>> data;
    List<Item>  list;
    static List<String> imgList;

    public Mock(){
        list = new ArrayList<>();
        imgList = new ArrayList<>();
        imgList.add("https://firebasestorage.googleapis.com/v0/b/nike-store-94e3e.appspot.com/o/nike-metcon-4.png?alt=media&token=cee42a27-176b-465d-b89a-9f94e9e21d5c");
        imgList.add("https://firebasestorage.googleapis.com/v0/b/nike-store-94e3e.appspot.com/o/nike-metcon-6.png?alt=media&token=e29a028f-e265-409d-a8c6-549b412f4251");
        imgList.add("https://firebasestorage.googleapis.com/v0/b/nike-store-94e3e.appspot.com/o/nike-metcon-5-black.png?alt=media&token=f6c18876-01fb-4ca9-8423-c140a49e4cd7");
        imgList.add("https://firebasestorage.googleapis.com/v0/b/nike-store-94e3e.appspot.com/o/nike-metcon-free.png?alt=media&token=9dd7c8a8-5e6e-42f2-b8b9-3315307c410a");

        Item item1 = new Item();
        item1.setName("Nike Metcon 4");
        item1.setBground("#414045");
        item1.setPrice(5000.1f);
        item1.setImg(new ArrayList<>(Arrays.asList
                ("https://firebasestorage.googleapis.com/v0/b/nike-store-94e3e.appspot.com/o/nike-metcon-4.png?alt=media&token=cee42a27-176b-465d-b89a-9f94e9e21d5c",
                        "https://firebasestorage.googleapis.com/v0/b/nike-store-94e3e.appspot.com/o/nike-metcon-4.png?alt=media&token=cee42a27-176b-465d-b89a-9f94e9e21d5c",
                        "https://firebasestorage.googleapis.com/v0/b/nike-store-94e3e.appspot.com/o/nike-metcon-4.png?alt=media&token=cee42a27-176b-465d-b89a-9f94e9e21d5c")));
        list.add(item1);

        Item item2 = new Item();
        item2.setName("Nike Metcon 6");
        item2.setBground("#4EABA6");
        item2.setPrice(5500);
        item2.setImg(new ArrayList<>(Arrays.asList
                ("https://firebasestorage.googleapis.com/v0/b/nike-store-94e3e.appspot.com/o/nike-metcon-6.png?alt=media&token=e29a028f-e265-409d-a8c6-549b412f4251",
                        "https://firebasestorage.googleapis.com/v0/b/nike-store-94e3e.appspot.com/o/nike-metcon-6.png?alt=media&token=e29a028f-e265-409d-a8c6-549b412f4251",
                        "https://firebasestorage.googleapis.com/v0/b/nike-store-94e3e.appspot.com/o/nike-metcon-6.png?alt=media&token=e29a028f-e265-409d-a8c6-549b412f4251")));
        list.add(item2);

        Item item3 = new Item();
        item3.setName("Nike Metcon 5");
        item3.setBground("#2B4660");
        item3.setPrice(7250);
        item3.setImg(new ArrayList<>(Arrays.asList
                ("https://firebasestorage.googleapis.com/v0/b/nike-store-94e3e.appspot.com/o/nike-metcon-5-black.png?alt=media&token=f6c18876-01fb-4ca9-8423-c140a49e4cd7",
                        "https://firebasestorage.googleapis.com/v0/b/nike-store-94e3e.appspot.com/o/nike-metcon-5-black.png?alt=media&token=f6c18876-01fb-4ca9-8423-c140a49e4cd7",
                        "https://firebasestorage.googleapis.com/v0/b/nike-store-94e3e.appspot.com/o/nike-metcon-5-black.png?alt=media&token=f6c18876-01fb-4ca9-8423-c140a49e4cd7")));
        list.add(item3);

        Item item4 = new Item();
        item4.setName("Nike Metcon 3");
        item4.setBground("#A69285");
        item4.setPrice(6000);
        item4.setImg(new ArrayList<>(Arrays.asList
                ("https://firebasestorage.googleapis.com/v0/b/nike-store-94e3e.appspot.com/o/nike-metcon-3.png?alt=media&token=4084bb9a-e410-425e-8d3b-02fa9fe43e25",
                        "https://firebasestorage.googleapis.com/v0/b/nike-store-94e3e.appspot.com/o/nike-metcon-3.png?alt=media&token=4084bb9a-e410-425e-8d3b-02fa9fe43e25",
                        "https://firebasestorage.googleapis.com/v0/b/nike-store-94e3e.appspot.com/o/nike-metcon-3.png?alt=media&token=4084bb9a-e410-425e-8d3b-02fa9fe43e25")));
        list.add(item4);

        Item item5 = new Item();
        item5.setName("Nike Metcon Free");
        item5.setBground("#A02E41");
        item5.setPrice(8000);
        item5.setImg(new ArrayList<>
                (Arrays.asList
                        ("https://firebasestorage.googleapis.com/v0/b/nike-store-94e3e.appspot.com/o/nike-metcon-free.png?alt=media&token=9dd7c8a8-5e6e-42f2-b8b9-3315307c410a",
                                "https://firebasestorage.googleapis.com/v0/b/nike-store-94e3e.appspot.com/o/nike-metcon-free.png?alt=media&token=9dd7c8a8-5e6e-42f2-b8b9-3315307c410a",
                                "https://firebasestorage.googleapis.com/v0/b/nike-store-94e3e.appspot.com/o/nike-metcon-free.png?alt=media&token=9dd7c8a8-5e6e-42f2-b8b9-3315307c410a")));
        list.add(item5);

        data = new MutableLiveData<>(list);

    }
    @Override
    public MutableLiveData<List<Item>> getAllItem() {
        return data;
    }

    @Override
    public void addItem(Item item) {
        list.add(item);

        data.setValue(list);
    }

    @Override
    public void deleteItem(Item item) {
        list.remove(item);

        data.setValue(list);
    }

    public void updateSetter(@NonNull Item prevItem, @NonNull Item item){
        try {
            prevItem.setName(item.getName());
            prevItem.setPrice(item.getPrice());
            prevItem.setBground(item.getBground());
            prevItem.setDescription(item.getDescription());
            prevItem.setSizes(item.getSizes());
            prevItem.setImg(item.getImg());
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateItem(Item item) {
        for (Item prevItem:list
             ) {
            if(prevItem.getId().equals(item.getId())){
                updateSetter(prevItem, item);
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public  MutableLiveData<Item> findItem(String uid, LifecycleOwner owner) {
        MutableLiveData<Item> specificItem = new MutableLiveData<>();

        data.observe(owner, (List<Item> parties) -> {
            specificItem.setValue(parties.stream()
                    .filter(party -> uid.equals(party.getId()))
                    .findAny()
                    .orElse(null)
            );
        });

        return specificItem;
    }


    public void toListString() {
        for (Item item:list
             ) {
            System.out.println(
                    item.getId()+ " "+
                            item.getName()
                    + " " + item.getPrice()
            );
        }
    }

    public static String randomImgUrl(){
        int index = (int) (Math.random() * imgList.size());
        return imgList.get(index);
    }
}
