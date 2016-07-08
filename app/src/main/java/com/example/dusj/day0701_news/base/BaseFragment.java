package com.example.dusj.day0701_news.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by dusj on 2016/7/2.
 */
public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(setViewId(), container, false);
        init();
        findViews(view);
        initEvent();
        loadDatas();
        return view;
    }

    protected abstract int setViewId();

    protected void init() {
    }

    protected abstract void findViews(View view);

    protected void initEvent() {
    }

    protected void loadDatas() {
    }
}
