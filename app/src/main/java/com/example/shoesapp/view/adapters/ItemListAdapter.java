package com.example.shoesapp.view.adapters;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoesapp.DI.ServiceLocator;
import com.example.shoesapp.MainActivity;
import com.example.shoesapp.Presentation.Operations.locale.CurrencyLocale;
import com.example.shoesapp.Presentation.Repository.Model.ItemDTO;
import com.example.shoesapp.R;
import com.example.shoesapp.databinding.ItemListElementBinding;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Locale;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemViewHolder> {
    private List<ItemDTO> data;
    private MainActivity mActivity;
    final int DIALOG_EXIT = 1;
    private List<String> images;
    public ItemListAdapter(List<ItemDTO> data, MainActivity activity) {
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

    @SuppressLint("Recycle")
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

        System.out.println(data.get(position).getImages());

        holder.binding.itemCard.setOnLongClickListener(item -> {
//            System.out.println(data.get(position).getImg().get(0));
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
//TODO: Picasso
        if(data.get(position).getImages() != null){
            try {
                holder.binding.cardImageView.setImageBitmap(
                        BitmapFactory.decodeFileDescriptor(
                                mActivity.getApplicationContext().getContentResolver().openFileDescriptor(
                                        Uri.parse(data.get(position).getImages().get(0)), "r").getFileDescriptor()
                        )
                );
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        holder.binding.itemName.setText(data.get(position).getName());

        holder.binding.itemPrice.setText(CurrencyLocale.getCurrency(new Locale("ru", "Ru"))
                .format(data.get(position).getPrice()));

    }
    public static int getScreenWidth(Context context) {
        WindowManager wm= (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public List<ItemDTO> getData() {
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
