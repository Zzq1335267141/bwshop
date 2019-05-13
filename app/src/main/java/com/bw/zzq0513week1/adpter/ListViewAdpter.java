package com.bw.zzq0513week1.adpter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.zzq0513week1.R;
import com.bw.zzq0513week1.bean.NewsBean;

import java.util.List;

/**
 * Created by Android Studio.
 * User: 张泽强
 * Date: 2019/5/13
 * Time: 10:16
 */
public class ListViewAdpter extends BaseAdapter {
    private List<NewsBean> list;
    private Context context;

    public ListViewAdpter(List<NewsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int itemViewType = getItemViewType(position);
        switch (itemViewType){
            case 0:
                ViewHolder1 viewHolder1;
                if(convertView==null){
                    viewHolder1 = new ViewHolder1();
                    convertView=View.inflate(context,R.layout.lv_one,null);
                    viewHolder1.tv1=convertView.findViewById(R.id.o_tv1);
                    viewHolder1.img=convertView.findViewById(R.id.o_img);
                    viewHolder1.tv2=convertView.findViewById(R.id.o_tv2);
                    convertView.setTag(viewHolder1);
                }else{
                    viewHolder1 = (ViewHolder1)convertView.getTag();
                }
                viewHolder1.tv1.setText(list.get(position).getTitle());
                Glide.with(context).load(list.get(position).getImage()).into(viewHolder1.img);
                viewHolder1.tv2.setText(list.get(position).getDesc());
                break;
            case 1:
                ViewHolder2 viewHolder2;
                if(convertView==null){
                    viewHolder2 = new ViewHolder2();
                    convertView=View.inflate(context,R.layout.lv_two,null);
                    viewHolder2.img1=convertView.findViewById(R.id.t_img1);
                    viewHolder2.img2=convertView.findViewById(R.id.t_img2);
                    viewHolder2.img3=convertView.findViewById(R.id.t_img3);
                    convertView.setTag(viewHolder2);
                }else{
                    viewHolder2 = (ViewHolder2)convertView.getTag();
                }
                Glide.with(context).load(list.get(position).getPic().get(0)).into(viewHolder2.img1);
                Glide.with(context).load(list.get(position).getPic().get(1)).into(viewHolder2.img2);
                Glide.with(context).load(list.get(position).getPic().get(2)).into(viewHolder2.img3);
                break;
        }
        return convertView;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).getType();
    }

    private static class ViewHolder1 {
        TextView tv1;
        ImageView img;
        TextView tv2;
    }
    private static class ViewHolder2 {
        ImageView img1;
        ImageView img2;
        ImageView img3;
    }
}
