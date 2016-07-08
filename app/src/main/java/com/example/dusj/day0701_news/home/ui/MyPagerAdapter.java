package com.example.dusj.day0701_news.home.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

/**
 * Created by dusj on 2016/7/1.
 */
public class MyPagerAdapter extends FragmentPagerAdapter {
    private final Fragment[] fragments;
    public MyPagerAdapter(FragmentManager fm,Fragment[] fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    //给tablayout设置标题
    @Override
    public CharSequence getPageTitle(int position) {
        Log.e("TAG",fragments[position].getArguments().getString("titles"));
        return fragments[position].getArguments().getString("titles");
    }

}
