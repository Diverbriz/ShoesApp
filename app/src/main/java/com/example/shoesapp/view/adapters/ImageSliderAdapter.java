package com.example.shoesapp.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoesapp.MainActivity;
import com.example.shoesapp.databinding.ImageElementBinding;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageSliderAdapter extends RecyclerView.Adapter<ImageSliderAdapter.ImageSliderViewHolder>{

    MainActivity mActivity;
    List<String> images;


    public ImageSliderAdapter(List<String> images, MainActivity activity) {
        this.mActivity = activity;
        this.images = images;
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
       if(images.get(position) == null){
           holder.mBinding.imageSlide.setVisibility(View.GONE);
       }
       else {
           holder.mBinding.imageSlide.setVisibility(View.VISIBLE);
           try {
               holder.setImage(images.get(position));
           } catch (Exception e){
               e.printStackTrace();
           }
       }
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    class ImageSliderViewHolder extends RecyclerView.ViewHolder{
        ImageElementBinding mBinding;
        public ImageSliderViewHolder(@NonNull ImageElementBinding binding) {
            super(binding.getRoot());

            this.mBinding = binding;
        }

        public void setImage(String url){
            Picasso.with(mActivity.getApplicationContext())
                    .load(url)
                    .into(mBinding.imageSlide);
        }
    }
}
