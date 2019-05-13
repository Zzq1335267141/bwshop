package com.bw.zzq0513week1;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.bw.zzq0513week1.adpter.ListViewAdpter;
import com.bw.zzq0513week1.base.BaseActivity;
import com.bw.zzq0513week1.bean.NewsBean;
import com.bw.zzq0513week1.model.Model;
import com.bw.zzq0513week1.model.ModelImpl;
import com.bw.zzq0513week1.presenter.PresenterImpl;
import com.bw.zzq0513week1.view.IView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 *实现p层
 * Created by Android Studio.
 * User: 张泽强
 * Date: 2019/5/13
 * Time: 8:57
 */
public class MainActivity extends BaseActivity implements IView {
    private String path = "https://code.aliyun.com/598254259/FristProject/raw/master/bw_list.txt";
    private List<String> strings;
    private List<NewsBean> list = new ArrayList<>();
    private ListView lv;

    //加载视图
    @Override
    public int initLayout() {
        return R.layout.activity_main;
    }
    //寻找资源
    @Override
    public void findViewByid() {
        lv = (ListView) findViewById(R.id.m_lv);
    }
    //数据
    @Override
    public void initData() {
        PresenterImpl presenter = new PresenterImpl(this);
        presenter.startResult(path);


    }
    //监听
    @Override
    public void initListener() {

    }
    //解析的数据
    @Override
    public void setResponse(String data) {
        Log.i("TAG",data);
       //使用原生解析
        try {
            //第一层
            JSONObject jsonObject = new JSONObject(data);
            //第二层
            JSONArray items = jsonObject.getJSONArray("items");
            //第三层
            for (int i=0;i<items.length();i++){
                int type = items.getJSONObject(i).getInt("type");
                String title = items.getJSONObject(i).getString("title");
                String desc = items.getJSONObject(i).getString("desc");
                String image = items.getJSONObject(i).getString("image");
                JSONArray images = items.getJSONObject(i).getJSONArray("images");
                strings = new ArrayList<>();
                for (int j=0;j<images.length();j++){
                    String pic = images.getJSONObject(j).getString("pic");
                    strings.add(pic);
                }
                NewsBean newsBean = new NewsBean(type,title,desc,image,strings);
                list.add(newsBean);
            }

            Log.i("WSW",list.size()+"");
            Log.i("WSW",list.get(2).getPic().size()+"");
            ListViewAdpter listViewAdpter = new ListViewAdpter(list,MainActivity.this);
            lv.setAdapter(listViewAdpter);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
