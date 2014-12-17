package com.beautyideainterface.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.beautyideainterface.fragment.MainFragment;
import com.beautyideainterface.fragment.SecondFragment;

import java.util.ArrayList;

/**
 * Created by i-you on 14-12-17.
 */
public class TabPagerAdapter extends FragmentPagerAdapter {

    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int i) {
        Fragment mFragment = null;
        switch (i){
            case 0:
                mFragment = new MainFragment();
                break;
            case 1:
                mFragment = new SecondFragment();
                break;
        }
        return mFragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
