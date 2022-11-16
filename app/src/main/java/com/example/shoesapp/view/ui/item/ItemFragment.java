package com.example.shoesapp.view.ui.item;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shoesapp.DI.ServiceLocator;
import com.example.shoesapp.MainActivity;
import com.example.shoesapp.Presentation.Operations.locale.CurrencyLocale;
import com.example.shoesapp.Presentation.Repository.Model.ItemDTO;

import com.example.shoesapp.databinding.FragmentItemBinding;
import com.example.shoesapp.view.adapters.ImageSliderAdapter;
import com.example.shoesapp.viewModel.ItemViewModel;

import java.util.Locale;

public class ItemFragment extends Fragment {

    private ItemViewModel mViewModel;
    private FragmentItemBinding mBinding;
//    private final Locale locale = new Locale("ru", "RU");
    public static ItemFragment newInstance() {
        return new ItemFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = FragmentItemBinding.inflate(inflater, container, false);

        mViewModel = new ViewModelProvider(this).get(ItemViewModel.class);
        if (getArguments() != null) {
            mViewModel.setItem(
                    ServiceLocator.getInstance().getGson().fromJson(getArguments().getString("Item"), ItemDTO.class)
            );
            System.out.println("Item Name " + mViewModel.getItemLiveData());
            System.out.println("Create View " + getArguments());
            mBinding.fragmentItemName.setText(mViewModel.getItem().getName());
            mBinding.priceTextview.setText(CurrencyLocale.getCurrency(new Locale("ru", "RU"))
                    .format(mViewModel.getItem().getPrice()));


            mBinding.addImageSlider.setAdapter(new ImageSliderAdapter(mViewModel.getItem().getImages(),
                    (MainActivity) requireActivity()));

            mViewModel.getItemLiveData().observe(getViewLifecycleOwner(), itemDTO -> {
                mBinding.fragmentItemName.setText(mViewModel.getItem().getName());
                mBinding.priceTextview.setText((int) mViewModel.getItem().getPrice());

                mBinding.addImageSlider.setAdapter(new ImageSliderAdapter(mViewModel.getItem().getImages(),
                        (MainActivity) requireActivity()));
            });

        }

       // View view = inflater.inflate(R.layout.fragment_item, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel

    }


}