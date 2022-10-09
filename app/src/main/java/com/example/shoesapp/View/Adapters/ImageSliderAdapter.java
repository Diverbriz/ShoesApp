package com.example.shoesapp.View.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.shoesapp.Domain.Models.Item;
import com.example.shoesapp.MainActivity;
import com.example.shoesapp.databinding.FragmentItemBinding;
import com.example.shoesapp.databinding.ImageElementBinding;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageSliderAdapter extends RecyclerView.Adapter<ImageSliderAdapter.ImageSliderViewHolder>{
    Item item;
    MainActivity mActivity;

    private ViewPager2 viewPager2;

    public ImageSliderAdapter(Item item, ViewPager2 viewPager2) {
        this.item = item;
        this.viewPager2 = viewPager2;
    }



    @NonNull
    @Override
    public ImageSliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ImageSliderViewHolder(ImageElementBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, true
        ),FragmentItemBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, true
        ) );
    }

    @Override
    public void onBindViewHolder(@NonNull ImageSliderViewHolder holder, int position) {
       holder.binding.fab.setOnClickListener((View v) ->{
           System.out.println("111");
       });
       holder.binding.fragmentItemName.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return item.getImg().size();
    }

    class ImageSliderViewHolder extends RecyclerView.ViewHolder{

        ImageElementBinding mBinding;
        FragmentItemBinding binding;
        private ImageView imageView;

        Context context;
        public ImageSliderViewHolder(@NonNull ImageElementBinding inflate,
                                     FragmentItemBinding binding) {
            super(binding.getRoot());
            context = binding.getRoot().getContext();
            this.mBinding = mBinding;
            this.binding = binding;
        }

        public void setImage(String url){
            Picasso.with(mActivity.getApplicationContext())
                    .load(url)
                    .into(mBinding.imageSlide);
        }
    }
}
