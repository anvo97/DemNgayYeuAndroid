package com.example.anvinh.adapter.pager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.anvinh.fragment.DateFragment;
import com.example.anvinh.fragment.TimeFragment;

public class ViewPagerMain extends FragmentPagerAdapter {

    public ViewPagerMain(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0)
            return new DateFragment();
        else
            return new TimeFragment();
    }

    @Override
    public int getCount() {
        return 2;
    }
}
