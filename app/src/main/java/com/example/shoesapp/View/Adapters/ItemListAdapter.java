package com.example.shoesapp.View.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoesapp.Domain.Models.Item;
import com.example.shoesapp.MainActivity;
import com.example.shoesapp.databinding.FragmentHomeBinding;
import com.example.shoesapp.databinding.ItemListElementBinding;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.LinkedList;
import java.util.List;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemViewHolder> {
    private List<Item> data;
    private MainActivity mActivity;

    public ItemListAdapter(List<Item> data, MainActivity activity) {
        mActivity = activity;
        this.data = data;

    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListElementBinding binding = ItemListElementBinding.inflate(LayoutInflater
                .from(parent.getContext()), parent, false);

        return new ItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.binding.itemCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("123");
            }
        });
        Picasso.with(mActivity.getApplicationContext())
                        .load(data.get(position).getImg().get(0))
                                .into(holder.binding.cardImageView);
        holder.binding.itemName.setText(data.get(position).getName());

        holder.binding.itemPrice.setText(data.get(position).getPrice()+"");
        if(data.get(position).getImg() != null && !data.get(position).getImg().isEmpty()){
            holder.binding.imageSlider.setVisibility(View.VISIBLE);

        }
        else {
            System.out.println("Изображения отсутствуют");
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public List<Item> getData() {
        return data;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{
        ItemListElementBinding binding;
        Context context;
        public ItemViewHolder(ItemListElementBinding binding) {
            super(binding.getRoot());
            this.context = binding.getRoot().getContext();
            this.binding = binding;
        }
    }
}
