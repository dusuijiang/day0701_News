package com.example.dusj.day0701_news.home.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.dusj.day0701_news.R;
import com.example.dusj.day0701_news.base.BaseFragment;
import com.example.dusj.day0701_news.commom.adapter.CommonAdapter;
import com.example.dusj.day0701_news.commom.adapter.ViewHolder;
import com.example.dusj.day0701_news.commom.net.ListviewCallBack;
import com.example.dusj.day0701_news.home.bean.NewsBean;
import com.example.dusj.day0701_news.home.dao.NewsDao;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dusj on 2016/7/1.
 */
public class MyFragment extends BaseFragment {

    private ListView mlistView;
    private String urlString;
    private CommonAdapter<NewsBean.ResultBean.DataBean> adapter;
    private List<NewsBean.ResultBean.DataBean> mlist;
    @Override
    protected int setViewId() {
        return R.layout.fragment_content;
    }

    @Override
    protected void init() {

        mlist = new ArrayList<>();
        adapter = new CommonAdapter<NewsBean.ResultBean.DataBean>(
                getActivity(),
                mlist,
                R.layout.layout_listview_item) {

            @Override
            public void convert(ViewHolder helper, int position, NewsBean.ResultBean.DataBean item) {
                helper.setText(R.id.title, item.nullTitle);
                helper.setImageByUrl(R.id.wap_thumb, item.nullThumbnailPicS, getActivity());
                helper.setText(R.id.nickname, item.nullAuthorName);
                helper.setText(R.id.create_time, item.nullDate);
            }

        };
    }
    @Override
    protected void findViews(View view) {
        mlistView = (ListView) view.findViewById(R.id.lv);
    }

    @Override
    protected void initEvent() {
        mlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String contentUrl = mlist.get(position).nullUrl;//得到内容的URL
                Intent intent = new Intent(getActivity(),ContentActivity.class);
                intent.putExtra("Url",contentUrl);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void loadDatas() {
        Bundle bundle = getArguments();
        urlString = bundle.getString("strUrl");
        NewsDao.getNewsData(urlString,
                new ListviewCallBack() {

                    @Override
                    public void updateListview(Object object) {
                        List<NewsBean.ResultBean.DataBean> list = (List<NewsBean.ResultBean.DataBean>) object;
                        mlist.addAll(list);
                        adapter.notifyDataSetChanged();
                    }
                }, getActivity());

        mlistView.setAdapter(adapter);
    }

}
