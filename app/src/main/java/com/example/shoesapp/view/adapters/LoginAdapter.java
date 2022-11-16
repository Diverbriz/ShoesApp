package com.example.shoesapp.view.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.shoesapp.view.ui.login_activity.fragments.LoginTabFragment;
import com.example.shoesapp.view.ui.login_activity.fragments.SignupTabFragment;

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


