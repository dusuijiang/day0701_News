package com.example.dusj.day0701_news.home.ui;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by dusj on 2016/7/2.
 * 第一个页面头文件滑动图片的adapter
 */
public class MyHeaderPagerAdapter extends PagerAdapter {

    private final List<ImageView> views;

    public MyHeaderPagerAdapter(List<ImageView> views) {
        this.views = views;
    }

    //返回要显示的页面数量
    @Override
    public int getCount() {
        return views.size();
    }


    /**
     * 添加每个页面的方法
     *
     * @param container 就是页面要装入容器---其实就是ViewPagger
     * @param position 页面的位置---跟数组对应
     *
     * @return 返回要添加的页面
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(views.get(position));
        return views.get(position);
    }

    /**
     * 用来判断instantiateItem返回的页面是不是真正添加的页面
     *
     * @param view
     * @param object
     *
     * @return
     */
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


    /**
     * //回调用于移除暂时不会用的页面
     *
     * @param container 页面的容器：就是VIewPager
     * @param position 要移除的位置
     * @param object 要移除的页面对象
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //自己移除页面
        container.removeView((View) object);
    }
}
