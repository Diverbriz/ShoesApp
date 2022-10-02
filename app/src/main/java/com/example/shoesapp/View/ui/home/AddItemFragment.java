package com.example.shoesapp.View.ui.home;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shoesapp.R;
import com.example.shoesapp.ViewModel.AddItemViewModel;
import com.example.shoesapp.databinding.FragmentAddItemBinding;

public class AddItemFragment extends Fragment {
    private FragmentAddItemBinding mBinding;
    private AddItemViewModel mViewModel;

    public static AddItemFragment newInstance() {
        return new AddItemFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = FragmentAddItemBinding.inflate(getLayoutInflater(), container, false);

        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AddItemViewModel.class);
        // TODO: Use the ViewModel
    }

}