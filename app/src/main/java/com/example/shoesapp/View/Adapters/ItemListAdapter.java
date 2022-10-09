package com.example.shoesapp.View.Adapters;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoesapp.DI.ServiceLocator;
import com.example.shoesapp.Domain.Models.Item;
import com.example.shoesapp.MainActivity;
import com.example.shoesapp.R;
import com.example.shoesapp.databinding.FragmentHomeBinding;
import com.example.shoesapp.databinding.ItemListElementBinding;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.LinkedList;
import java.util.List;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemViewHolder> {
    private List<Item> data;
    private MainActivity mActivity;
    final int DIALOG_EXIT = 1;
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
    public void onBindViewHolder(@NonNull ItemViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.binding.itemCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                String json = ServiceLocator.getInstance().getGson().toJson(data.get(position));
                bundle.putString("Item", json);
                System.out.println(json);
                Navigation.findNavController(mActivity.binding.frameLayout)
                        .navigate(R.id.action_homeFragment_to_itemFragment, bundle);
            }
        });

        holder.binding.itemCard.setOnLongClickListener(item -> {
            System.out.println("111");
            AlertDialog.Builder builder = new AlertDialog.Builder(holder.context);
            builder.setTitle(R.string.exit);
            builder.setMessage(R.string.delete_data);
            builder.setCancelable(true);
            builder.setNegativeButton(R.string.no, (dialogInterface, i) -> {
               dialogInterface.cancel();
            });
            builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() { // Кнопка ОК
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss(); // Отпускает диалоговое окно
                    ServiceLocator.getInstance().getRepository().deleteItem(data.get(position));
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();
            return true;
        });
        holder.binding.itemCard.setCardBackgroundColor(Color.LTGRAY);
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

    public void onCreateDialog(int id) {

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
