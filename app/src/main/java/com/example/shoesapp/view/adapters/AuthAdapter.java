package com.example.shoesapp.view.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.shoesapp.view.ui.login.LoginFragment;
import com.example.shoesapp.view.ui.login_activity.fragments.AuthViewPager;
import com.example.shoesapp.view.ui.login_activity.fragments.LoginTabFragment;
import com.example.shoesapp.view.ui.login_activity.fragments.SignupTabFragment;
import com.google.android.material.tabs.TabLayout;

public class AuthAdapter extends FragmentStateAdapter {
    private int tabCount;
    public AuthAdapter(FragmentActivity fragment, TabLayout tabLayout) {
        super(fragment);
        this.tabCount = tabLayout.getTabCount();
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        System.out.println(position);
        switch (position){
            case 0:
                return new LoginTabFragment();
            case 1:
                System.out.println(position);
                return new SignupTabFragment();
            default: return new SignupTabFragment();
        }
//        Fragment fragment = new LoginFragment();
    }

    @Override
    public int getItemCount() {
        return tabCount;
    }
}
