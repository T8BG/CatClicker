package com.lab.catclicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ShopFragmentAdapter extends FragmentStateAdapter {
    public ShopFragmentAdapter(@NonNull FragmentManager supportFragmentManager, @NonNull Lifecycle lifecycle) {
        super(supportFragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position){
            case 0:
                ClickerFragment clickerFragment = new ClickerFragment();
                return clickerFragment;
            case 1:
                ShopFragment shopFragment = new ShopFragment();
                return shopFragment;
            default:
                return null;
        }

    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
