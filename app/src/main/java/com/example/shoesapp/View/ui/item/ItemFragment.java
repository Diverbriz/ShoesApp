package com.example.shoesapp.View.ui.item;

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
import com.example.shoesapp.Presentation.Repository.Model.ItemDTO;

import com.example.shoesapp.View.adapters.ImageSliderAdapter;
import com.example.shoesapp.viewModel.ItemViewModel;
import com.example.shoesapp.databinding.FragmentItemBinding;

public class ItemFragment extends Fragment {

    private ItemViewModel mViewModel;
    private FragmentItemBinding mBinding;

    public static ItemFragment newInstance() {
        return new ItemFragment();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
            mBinding.addImageSlider.setAdapter(new ImageSliderAdapter(mViewModel.getItem().getImages(),
                    (MainActivity) requireActivity()));
            mViewModel.getItemLiveData().observe(getViewLifecycleOwner(), itemDTO -> {
                mBinding.fragmentItemName.setText("itemDTO.getName()");
                mBinding.addImageSlider.setAdapter(new ImageSliderAdapter(mViewModel.getItem().getImages(),
                        (MainActivity) requireActivity()));
            });


//            mViewModel.getLiveData().observe(getViewLifecycleOwner(), itemDTO -> {
//                mBinding.fragmentItemName.setText(itemDTO.getName());
//            });
        }


//        if(mViewModel.getItem() != null){
//            System.out.println(mViewModel.getItem().getImg());
//
//            mBinding.imageSlider.setAdapter(new ImageSliderAdapter(mViewModel.getItem(), mBinding.imageSlider));
//            mBinding.imageSlider.setClipToPadding(false);
//            mBinding.imageSlider.setClipChildren(false);
//            mBinding.imageSlider.setOffscreenPageLimit(4);
//            mBinding.imageSlider.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
//            CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
//            compositePageTransformer.addTransformer(new MarginPageTransformer(40));
//            compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
//                @Override
//                public void transformPage(@NonNull View page, float position) {
//                    float r = 1 -Math.abs(position);
//                    page.setScaleX(0.85f + r * 0.15f);
//                }
//            });
//            mBinding.imageSlider.setPageTransformer(compositePageTransformer);
//        }
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