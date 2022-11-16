package com.example.shoesapp.view.adapters;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoesapp.MainActivity;
import com.example.shoesapp.databinding.AddImageElementBinding;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AddImageAdapter extends RecyclerView.Adapter<AddImageAdapter.AddImageSliderViewHolder> {

    List<String> images;
    MainActivity mActivity;

    public AddImageAdapter(List<String> images, boolean adding, MainActivity activity) {
        this.images = images;
        mActivity = activity;

        if (adding) {
            this.images.add(null);
        }
    }

    @NonNull
    @NotNull
    @Override
    public AddImageSliderViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new AddImageSliderViewHolder(AddImageElementBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(@NonNull @NotNull AddImageSliderViewHolder holder, int position) {
        if (images.get(position) == null) {
            holder.mBinding.imageContent.setVisibility(View.GONE);
            holder.mBinding.addButton.setVisibility(View.VISIBLE);
            holder.mBinding.addButton.setOnClickListener((View v) -> {
                if (mActivity != null) {
                    mActivity.getActivityResultRegistry().register("key", new ActivityResultContracts.OpenDocument(), result -> {
                        mActivity.getApplicationContext().getContentResolver().takePersistableUriPermission(
                                result,
                                Intent.FLAG_GRANT_READ_URI_PERMISSION
                        );

                        images.add(images.size() - 1, result.toString());
                        notifyDataSetChanged();
                    }).launch(new String[]{"image/*"});
                }
            });
        } else {
            holder.mBinding.addButton.setVisibility(View.GONE);
            holder.mBinding.imageContent.setVisibility(View.VISIBLE);

            if (mActivity != null) {
                try {
                    holder.mBinding.imageContent.setImageBitmap(
                            BitmapFactory.decodeFileDescriptor(
                                    mActivity.getApplicationContext().getContentResolver().openFileDescriptor(
                                            Uri.parse(images.get(position)), "r").getFileDescriptor()
                            )
                    );
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    class AddImageSliderViewHolder extends RecyclerView.ViewHolder{

        AddImageElementBinding mBinding;

        public AddImageSliderViewHolder(AddImageElementBinding binding) {
            super(binding.getRoot());

            mBinding = binding;
        }
    }
}