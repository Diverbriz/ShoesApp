package com.example.shoesapp.View.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoesapp.MainActivity;
import com.example.shoesapp.Presentation.Repository.Model.ItemDTO;
import com.example.shoesapp.R;
import com.example.shoesapp.View.adapters.ItemListAdapter;
import com.example.shoesapp.viewModel.HomeViewModel;
import com.example.shoesapp.databinding.ActivityMainBinding;
import com.example.shoesapp.databinding.FragmentHomeBinding;

import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding mBinding;
    private HomeViewModel mHomeViewModel;
    private RecyclerView recyclerView;
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
//        LinearLayoutManager linearLayoutManager =
//                new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);

        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        binding = ((MainActivity) requireActivity()).binding;
        mBinding.fab.setOnClickListener(item -> {
            if(item.getId() == R.id.fab){
                mBinding.getRoot().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Navigation.findNavController(mBinding.getRoot()).navigate(R.id.action_homeFragment_to_addItemFragment);
                    }
                }, 1000);

            }
        });

//      mHomeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return mBinding.getRoot();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mHomeViewModel.getItem().observe(getViewLifecycleOwner(), (List<ItemDTO> itemList) -> {
            System.out.println(itemList);
            mBinding.listItem.setAdapter(new ItemListAdapter(itemList, (MainActivity)requireActivity()));
        });

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBinding = null;
        mHomeViewModel = null;
    }
}