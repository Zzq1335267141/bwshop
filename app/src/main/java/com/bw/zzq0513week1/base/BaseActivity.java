package com.bw.zzq0513week1.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Activity抽积类
 * Created by Android Studio.
 * User: 张泽强
 * Date: 2019/5/13
 * Time: 8:57
 */
public abstract class BaseActivity extends AppCompatActivity {
    //加载视图
    public abstract int initLayout();
    //寻找资源
    public abstract void findViewByid();
    //数据
    public abstract void initData();
    //监听
    public abstract void initListener();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        findViewByid();
        initData();
        initListener();
    }
}
