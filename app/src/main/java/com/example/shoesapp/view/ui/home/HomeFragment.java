package com.example.shoesapp.view.ui.home;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoesapp.MainActivity;
import com.example.shoesapp.Presentation.Repository.Model.DataModel;
import com.example.shoesapp.Presentation.Repository.Model.ItemDTO;
import com.example.shoesapp.Presentation.Repository.Model.Support;
import com.example.shoesapp.Presentation.Repository.network.Methods;
import com.example.shoesapp.Presentation.Repository.network.RetrofitClient;
import com.example.shoesapp.Presentation.Repository.network.retrofit.model.User;
import com.example.shoesapp.Presentation.Repository.network.retrofit.model.UserModel;
import com.example.shoesapp.R;
import com.example.shoesapp.databinding.ActivityMainBinding;
import com.example.shoesapp.databinding.FragmentHomeBinding;
import com.example.shoesapp.view.adapters.ItemListAdapter;
import com.example.shoesapp.viewModel.HomeViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding mBinding;
    private HomeViewModel mHomeViewModel;
    private RecyclerView recyclerView;
    private ActivityMainBinding binding;
    private Methods methods;
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
        methods = RetrofitClient.getRetrofitInstance().create(Methods.class);
        mBinding.fab.setOnClickListener(item -> {
            Call<UserModel> call = methods.getAllUsers("2");
            call.enqueue(new Callback<UserModel>() {
                @Override
                public void onResponse(@NonNull Call<UserModel> call, @NonNull Response<UserModel> response) {
                    Log.e(TAG, "On Response code: " + call.request());

                    ArrayList<DataModel> dataModels = response.body().getData();
                    Support support = response.body().getSupport();

                    Log.e(TAG, "On Response data:" + support.toString());

                    Log.e(TAG, "On Response data:"+"\n\n\n" + response);
                    for (DataModel data1: dataModels
                         ) {
                        Log.e(TAG, "On Response data:" + data1.getEmail());
                    }

                }

                @Override
                public void onFailure(Call<UserModel> call, Throwable t) {
                    Log.e(TAG, "On Error Response data:" + call.request());
                }
            });

            Call<User> call1 = methods.getOneUser(2);
            call1.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    Log.e(TAG, "On Response User " + response.body().getData().toString());
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {

                }
            });

                mBinding.getRoot().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Navigation.findNavController(mBinding.getRoot())
                                .navigate(R.id.action_homeFragment_to_addItemFragment);
                    }
                }, 1000);
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