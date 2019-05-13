package com.bw.zzq0513week1.presenter;

import com.bw.zzq0513week1.view.IView;

/**
 * Created by Android Studio.
 * User: 张泽强
 * Date: 2019/5/13
 * Time: 9:20
 */
public interface Presenter {
    //交互
    void onTach(IView iView);
    //数据
    void startResult(String uri);
    //防止溢出
    void deTach();
}
