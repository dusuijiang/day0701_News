package com.example.dusj.day0701_news.commom.net;

/**
 * Created by dusj on 2016/6/27.
 * 网络访问的回调接口
 */
public interface NetCallback {
     void success(String strResult);
     void fail(String Msg);

}
