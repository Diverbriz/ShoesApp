package com.example.shoesapp.View.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoesapp.Domain.Models.Item;
import com.example.shoesapp.MainActivity;
import com.example.shoesapp.R;
import com.example.shoesapp.View.Adapters.ItemListAdapter;
import com.example.shoesapp.ViewModel.HomeViewModel;
import com.example.shoesapp.databinding.ActivityMainBinding;
import com.example.shoesapp.databinding.FragmentHomeBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import java.util.Objects;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding mBinding;
    private HomeViewModel mHomeViewModel;
    private RecyclerView recyclerView;
    private NavController navController;
    private ActivityMainBinding binding;
    public static HomeFragment newInstance(){
        return new HomeFragment();
    }



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mHomeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        mBinding =
                FragmentHomeBinding.inflate(getLayoutInflater(), container, false);
        mBinding.listItem.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView = mBinding.listItem;
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));



//      mHomeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return mBinding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mHomeViewModel.getItem().observe(getViewLifecycleOwner(), (List<Item> itemList) -> {
            System.out.println(itemList);
            mBinding.listItem.setAdapter(new ItemListAdapter(itemList, (MainActivity)requireActivity()));
        });
        binding = ((MainActivity) requireActivity()).binding;
        mBinding.fab.setOnClickListener(item -> {
            if(item.getId() == R.id.fab){
                System.out.println(mBinding.fab);

            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBinding = null;
        mHomeViewModel = null;
    }
}