package com.example.dusj.day0701_news.home.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dusj.day0701_news.R;
import com.example.dusj.day0701_news.base.BaseActivity;
import com.example.dusj.day0701_news.commom.constant.Constant;

public class MainActivity extends BaseActivity {

    private ViewPager viewPager;
    private String[] titles;
    private String[] strUrl;
    private TabLayout mtabLayout;

    @Override
    protected int setViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void findViews() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        mtabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mtabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);//设置tablayout可滚动

    }
    @Override
    protected void init() {
        strUrl = new String[]{
                "http://v.juhe.cn/toutiao/index?type=toutiao&key=8d133165be92fc11958625d3a4e6cd47",
                "http://v.juhe.cn/toutiao/index?type=shehui&key=8d133165be92fc11958625d3a4e6cd47",
                "http://v.juhe.cn/toutiao/index?type=guonei&key=8d133165be92fc11958625d3a4e6cd47",
                "http://v.juhe.cn/toutiao/index?type=guoji&key=8d133165be92fc11958625d3a4e6cd47",
                "http://v.juhe.cn/toutiao/index?type=yule&key=8d133165be92fc11958625d3a4e6cd47",
                "http://v.juhe.cn/toutiao/index?type=tiyu&key=8d133165be92fc11958625d3a4e6cd47",
                "http://v.juhe.cn/toutiao/index?type=junshi&key=8d133165be92fc11958625d3a4e6cd47",
                "http://v.juhe.cn/toutiao/index?type=keji&key=8d133165be92fc11958625d3a4e6cd47",
                "http://v.juhe.cn/toutiao/index?type=caijing&key=8d133165be92fc11958625d3a4e6cd47",
                "http://v.juhe.cn/toutiao/index?type=shishang&key=8d133165be92fc11958625d3a4e6cd47",};

        titles = new String[]{"头条","社会", "国内", "国际", "娱乐",
                "体育", "军事", "科技", "财经", "时尚"};

        Fragment[] fragments = new Fragment[titles.length ];
        fragments[0] = new MyHeaderFragment();//初始化第一个fragment，第一个fragment存在广告页
        Bundle bundle = new Bundle();
        bundle.putString("titles",titles[0]);
        bundle.putString("strUrl", strUrl[0]);
        fragments[0].setArguments(bundle);

        for (int i = 1; i < titles.length; i++) {
            Bundle bundle1 = new Bundle();
            fragments[i] = new MyFragment();
            bundle1.putString("titles", titles[i]);
            bundle1.putString("strUrl", strUrl[i]);
            fragments[i].setArguments(bundle1);
        }

        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);

        //将tablayout和ViewPager绑定
        mtabLayout.setupWithViewPager(viewPager);
    }

}
