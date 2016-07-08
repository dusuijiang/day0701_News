package com.example.dusj.day0701_news.home.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import com.example.dusj.day0701_news.R;
import com.example.dusj.day0701_news.base.BaseFragment;
import com.example.dusj.day0701_news.commom.adapter.CommonAdapter;
import com.example.dusj.day0701_news.commom.adapter.ViewHolder;
import com.example.dusj.day0701_news.commom.net.ListviewCallBack;
import com.example.dusj.day0701_news.home.bean.NewsBean;
import com.example.dusj.day0701_news.home.dao.NewsDao;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dusj on 2016/7/2.
 */
public class MyHeaderFragment extends BaseFragment {
    private ListView mlistView;
    private CommonAdapter<NewsBean.ResultBean.DataBean> madapter;
    private List<NewsBean.ResultBean.DataBean> mlist;
    private ViewPager mviewPager;
    private List<ImageView> mViewsContents;
    private ImageView mimageView;

    @Override
    protected int setViewId() {
        return R.layout.fragment_content;
    }

    @Override
    protected void init() {
        mViewsContents = new ArrayList<>();
        mlist = new ArrayList<>();
    }

    @Override
    protected void findViews(View view) {
        mlistView = (ListView) view.findViewById(R.id.lv);
        View mview = LayoutInflater.from(getActivity()).inflate(R.layout.layout_header, null);
        mviewPager = (ViewPager) mview.findViewById(R.id.header_viewPager);//头部的ViewPager
        mlistView.addHeaderView(mview);//为ListView设置头部可滑动图片

        madapter = new CommonAdapter<NewsBean.ResultBean.DataBean>(
                getActivity(),
                mlist,
                R.layout.layout_listview_item) {

            @Override
            public void convert(ViewHolder helper, int position, NewsBean.ResultBean.DataBean item) {
                helper.setText(R.id.title, item.nullTitle);
                helper.setImageByUrl(R.id.wap_thumb, item.nullThumbnailPicS, getActivity());
                helper.setText(R.id.nickname, item.nullAuthorName);
                helper.setText(R.id.create_time, item.nullDate);

                for (int i = 0; i < 5; i++) {
                    mimageView = new ImageView(getActivity());
                    Log.e("TAG",mlist.size() + "");
                    String imageUri = mlist.get(10+i).nullThumbnailPicS;//得到图片的url;
                    //String contentUrl = mlist.get(i+10).nullUrl; //得到内容的url;
                    mimageView.setScaleType(ImageView.ScaleType.CENTER_CROP);//设置图片填充屏幕
                    Picasso.with(getActivity()).load(imageUri).into(mimageView);//设置图片
                    mViewsContents.add(mimageView);
                }

                //对ViewPager绑定视图
                MyHeaderPagerAdapter myHeaderPagerAdapter = new MyHeaderPagerAdapter(mViewsContents);
                mviewPager.setAdapter(myHeaderPagerAdapter);
            }
        };
        mlistView.setAdapter(madapter);
    }

    @Override
    protected void initEvent() {
        mlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String contentUrl = mlist.get(position).nullUrl;//得到内容的URL,实现页面跳转
                Intent intent = new Intent(getActivity(),ContentActivity.class);
                intent.putExtra("Url",contentUrl);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void loadDatas() {
        Bundle bundle = getArguments();
        String urlString = bundle.getString("strUrl");
        NewsDao.getNewsData(urlString,
                new ListviewCallBack() {

                    @Override
                    public void updateListview(Object object) {
                        List<NewsBean.ResultBean.DataBean> list = (List<NewsBean.ResultBean.DataBean>) object;
                        mlist.addAll(list);
                        madapter.notifyDataSetChanged();
                    }
                }, getActivity());
    }
}
