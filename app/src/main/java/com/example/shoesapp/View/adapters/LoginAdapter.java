package com.example.shoesapp.View.adapters;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.shoesapp.View.ui.login_activity.fragments.LoginTabFragment;
import com.example.shoesapp.View.ui.login_activity.fragments.SignupTabFragment;

public class LoginAdapter extends FragmentStateAdapter {
    int totalTabs;
    public LoginAdapter(FragmentActivity fa, int totalTabs) {
        super(fa);
        this.totalTabs = totalTabs;
    }

    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
            return new LoginTabFragment();
            case 1:
                System.out.println(position);
                return new SignupTabFragment();
            default: return null;
        }
    }

    @Override
    public int getItemCount() {
        return totalTabs;
    }
}


