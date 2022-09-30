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
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoesapp.Domain.Models.Item;
import com.example.shoesapp.MainActivity;
import com.example.shoesapp.View.Adapters.ItemListAdapter;
import com.example.shoesapp.ViewModel.HomeViewModel;
import com.example.shoesapp.databinding.ActivityMainBinding;
import com.example.shoesapp.databinding.FragmentHomeBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding mBinding;
    private HomeViewModel mHomeViewModel;
    private RecyclerView recyclerView;
    private ActivityMainBinding activityMainBinding;

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

        mHomeViewModel.getItem().observe(getViewLifecycleOwner(), (List<Item> itemList) -> {
            System.out.println(itemList);
            mBinding.listItem.setAdapter(new ItemListAdapter(itemList, (MainActivity)requireActivity()));
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBinding = null;
        mHomeViewModel = null;
    }
}