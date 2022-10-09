package com.example.shoesapp.View.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.shoesapp.DI.ServiceLocator;
import com.example.shoesapp.MainActivity;
import com.example.shoesapp.Presentation.Repository.Mock.Mock;
import com.example.shoesapp.View.Adapters.Operations.SliderItem;
import com.example.shoesapp.databinding.ImageElementBinding;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageSliderAdapter extends RecyclerView.Adapter<ImageSliderAdapter.ImageSliderViewHolder>{
    List<String> images;
    MainActivity mActivity;

    private ViewPager2 viewPager2;

    public ImageSliderAdapter(List<String> images, ViewPager2 viewPager2) {
        this.images = images;
        this.viewPager2 = viewPager2;
    }



    @NonNull
    @Override
    public ImageSliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ImageSliderViewHolder(ImageElementBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull ImageSliderViewHolder holder, int position) {
        holder.setImage(images.get(1));
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    class ImageSliderViewHolder extends RecyclerView.ViewHolder{

        ImageElementBinding mBinding;
        private ImageView imageView;

        Context context;
        public ImageSliderViewHolder(ImageElementBinding binding) {
            super(binding.getRoot());
            context = binding.getRoot().getContext();
            mBinding = binding;
        }

        public void setImage(String url){
            Picasso.with(mActivity.getApplicationContext())
                    .load(url)
                    .into(mBinding.imageSlide);
        }
    }
}
