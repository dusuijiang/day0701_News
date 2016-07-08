package com.example.dusj.day0701_news.home.bean;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dusj on 2016/7/2.
 */
public class NewsBean {

    @SerializedName("reason")
    public String nullReason;
    @SerializedName("result")
    public ResultBean nullResult;
    @SerializedName("error_code")
    public int nullErrorCode;

    public static List<NewsBean> arrayNewsBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<NewsBean>>() {

        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static class ResultBean {

        @SerializedName("stat")
        public String nullStat;
        @SerializedName("data")
        public List<DataBean> nullData;

        public static List<ResultBean> arrayResultBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<ResultBean>>() {

            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static class DataBean {

            @SerializedName("title")
            public String nullTitle;
            @SerializedName("date")
            public String nullDate;
            @SerializedName("author_name")
            public String nullAuthorName;
            @SerializedName("thumbnail_pic_s")
            public String nullThumbnailPicS;
            @SerializedName("thumbnail_pic_s02")
            public String nullThumbnailPicS02;
            @SerializedName("thumbnail_pic_s03")
            public String nullThumbnailPicS03;
            @SerializedName("url")
            public String nullUrl;
            @SerializedName("uniquekey")
            public String nullUniquekey;
            @SerializedName("type")
            public String nullType;
            @SerializedName("realtype")
            public String nullRealtype;

            public static List<DataBean> arrayDataBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<DataBean>>() {

                }.getType();

                return new Gson().fromJson(str, listType);
            }
        }
    }
}
