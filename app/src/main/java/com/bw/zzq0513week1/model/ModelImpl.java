package com.bw.zzq0513week1.model;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Android Studio.
 * User: 张泽强
 * Date: 2019/5/13
 * Time: 9:09
 */
public class ModelImpl implements Model {
    @Override
    public void getRequestData(String uri, CallBack callBack) {
        new MyTask(uri,callBack).execute(uri);
    }
    //异步类
    class MyTask extends AsyncTask<String,Void,String>{
        private String uri;
        private CallBack callBack;
        public MyTask(String uri, CallBack callBack) {
            this.uri = uri;
            this.callBack = callBack;
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL(uri);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                //设置请求方式
                urlConnection.setRequestMethod("GET");
                //设置读取时间
                urlConnection.setReadTimeout(5000);
                //设置超时连接
                urlConnection.setConnectTimeout(5000);
                //判断请求码
                Log.i("WSX",urlConnection.getResponseCode()+"");
                if(urlConnection.getResponseCode()==200){
                    String s = ToString(urlConnection.getInputStream());
                    return s;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            callBack.setRequestData(s);
        }
    }
    //读写
    public String ToString(InputStream inputStream) throws IOException {
        //设置读取速率
        byte[] bytes = new byte[1024];
        //设置长度
        int len = -1;
        //安全存储
        StringBuffer buffer = new StringBuffer();
        //读写
        while ((len=inputStream.read(bytes))!=-1){
            String s = new String(bytes, 0, len);
            buffer.append(s);
        }
        return buffer.toString();
    }
}
