package com.example.dusj.day0701_news.home.dao;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dusj.day0701_news.commom.net.ListviewCallBack;
import com.example.dusj.day0701_news.home.bean.NewsBean;
import com.google.gson.Gson;
import java.util.List;

/**
 * Created by dusj on 2016/7/2.
 */

public class NewsDao {

    //解析下载的数据,通过接口回调将数据传到list中
    public static void getNewsData(String url, final ListviewCallBack listviewCallBack, Context context) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(url,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String str) {
                        Gson gson = new Gson();
                        NewsBean newsBean = gson.fromJson(str, NewsBean.class);
                        List<NewsBean.ResultBean.DataBean> dataBeen = newsBean.nullResult.nullData;
                        listviewCallBack.updateListview(dataBeen);
                    }
                },
                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                    }
                });
        requestQueue.add(stringRequest);
    }
}

