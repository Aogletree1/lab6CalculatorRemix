package com.example.lab6calculatorremix;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class TabLayoutAdapter extends FragmentStateAdapter{
    public static final int NUM_TABS = 3;

    public TabLayoutAdapter(Fragment fragment){
        super(fragment);

    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        Fragment fragmentB = null;
        Bundle args = new Bundle();

        switch (position) {
            case 0:
                Fragment fragment = new tempcalc();
                args.putInt(TabLayoutFragment.ARG_ID, position + 1);
                fragment.setArguments(args);
                return fragment;

            case 1:
                Fragment fragment2 = new tipcalc();
                args.putInt(TabLayoutFragment.ARG_ID, position + 1);
                fragment2.setArguments(args);
                return fragment2;
            case 2:
                Fragment fragment3 = new distancecalc();
                args.putInt(TabLayoutFragment.ARG_ID, position + 1);
                fragment3.setArguments(args);
                return fragment3;
        }



        return fragmentB;


    }

    @Override
    public int getItemCount() {
        return NUM_TABS;
    }

}


