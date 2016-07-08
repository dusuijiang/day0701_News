package com.example.dusj.day0701_news.commom.net;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Http_Utils {

	public interface OnLoadByteCallBack {
		void onProgress(int progress);
		boolean isDisconnect();
	}

	public static byte[] loadByte(String urlStr, OnLoadByteCallBack callBack) {
		InputStream is = null;
		ByteArrayOutputStream baos = null;
		HttpURLConnection conn = null;
		try {
			URL url = new URL(urlStr);
			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(10000);
			int code = conn.getResponseCode();
			if (code == HttpURLConnection.HTTP_OK) {
				final int max = conn.getContentLength();
				baos = new ByteArrayOutputStream();
				is = conn.getInputStream();
				int sum = 0;
				int len = 0;
				byte[] b = new byte[1024];
				while ((len = is.read(b)) != -1) {
					baos.write(b, 0, len);
					//Thread.sleep(50);
					if (callBack != null && callBack.isDisconnect()) {
						return null;
					}
					sum += len;
					if (callBack != null) {
						callBack.onProgress((int) (100.0 * sum / max));
					}
				}
				return baos.toByteArray();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  finally {
			try {
				baos.flush();
				baos.close();
				is.close();
				conn.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
