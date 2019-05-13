package com.bw.zzq0513week1.model;

/**
 * Created by Android Studio.
 * User: 张泽强
 * Date: 2019/5/13
 * Time: 9:07
 */
public interface Model {
    void getRequestData(String uri,CallBack callBack);
    public interface CallBack{
        void setRequestData(String info);
    }
}
