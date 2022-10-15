package com.example.shoesapp.View.ui.home;

import androidx.lifecycle.ViewModelProvider;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.shoesapp.DI.ServiceLocator;
import com.example.shoesapp.Domain.Models.Item;
import com.example.shoesapp.MainActivity;
import com.example.shoesapp.Presentation.Repository.Mock.Mock;
import com.example.shoesapp.R;
import com.example.shoesapp.ViewModel.AddItemViewModel;
import com.example.shoesapp.ViewModel.HomeViewModel;
import com.example.shoesapp.databinding.FragmentAddItemBinding;

import java.util.Arrays;

public class AddItemFragment extends Fragment {
    private FragmentAddItemBinding mBinding;
    private AddItemViewModel mViewModel;
    private HomeViewModel hViewModel;
    private MainActivity mActivity;

    public static AddItemFragment newInstance() {
        return new AddItemFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = FragmentAddItemBinding.inflate(getLayoutInflater(), container, false);
        mBinding.fab.setOnClickListener(item -> {
            validationEditText();
        });

        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AddItemViewModel.class);
        // TODO: Use the ViewModel
    }

    public void validationEditText(){
        if(mBinding.addItemName.getText().length() != 0 && mBinding.itemPrice.getText() != null){
            Item item = new Item();
            item.setName(String.valueOf(mBinding.addItemName.getText()));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                item.setPrice(mBinding.itemPrice.getAutofillType());
            }
            item.setImg(Arrays.asList("https://firebasestorage.googleapis.com/v0/b/nike-store-94e3e.appspot.com/o/nike-metcon-4.png?alt=media&token=cee42a27-176b-465d-b89a-9f94e9e21d5c"));

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                mViewModel.AddItem(
                        mBinding.addItemName.getText().toString(),
                        Float.parseFloat(mBinding.itemPrice.getText().toString()),
                        mBinding.itemDescription.getText().toString(),
                        Arrays.asList("https://firebasestorage.googleapis.com/v0/b/nike-store-94e3e.appspot.com/o/nike-metcon-4.png?alt=media&token=cee42a27-176b-465d-b89a-9f94e9e21d5c")
                );
            }
            ServiceLocator.getInstance().getRepository().getAllItem()
                    .observe(getViewLifecycleOwner(), itemList -> {
                        for (Item i:itemList
                        ) {
                            System.out.println(
                                    i.getId()+ " "+
                                            i.getName()
                                            + " " + i.getPrice()
                            );
                        }
                    });
//            Navigation.findNavController(getView())
//                    .navigate(R.id.action_addItemFragment_to_homeFragment);
        }
        else{
            Toast.makeText(getContext(), "Вы ввели не все данные", Toast.LENGTH_SHORT).show();
        }
    }

}