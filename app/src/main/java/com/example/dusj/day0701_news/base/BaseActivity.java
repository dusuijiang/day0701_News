package com.example.dusj.day0701_news.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by dusj on 2016/6/27.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setViewId());
        findViews();
        init();
        initEvents();
        loadData();
    }

    //设置布局文件
    protected abstract int setViewId();

    //初始化控件
    protected void findViews() {
    }

    //初始化
    protected void init() {
    }

    //初始化监听事件
    protected void initEvents() {
    }

    //加载数据
    protected void loadData() {
    }
}
