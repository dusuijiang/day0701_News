package com.example.dusj.day0701_news.commom.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.io.File;

/**
 * Created by zhouyi on 16/4/14.
 */
public class FileUtils {

    /**
     * 安装apk文件的方法
     * @param context 上下文
     * @param file apk文件所在的路径和文件名
     */
    public static void installApk(Context context, File file) {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(Intent.ACTION_VIEW);
        String type = "application/vnd.android.package-archive";
        intent.setDataAndType(Uri.fromFile(file), type);
        context.startActivity(intent);
    }
}
