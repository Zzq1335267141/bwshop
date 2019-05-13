package com.bw.zzq0513week1.bean;

import java.util.List;

/**
 * bean类
 * Created by Android Studio.
 * User: 张泽强
 * Date: 2019/5/13
 * Time: 10:01
 */
public class NewsBean {
    private Integer type;
    private String title;
    private String desc;
    private String image;
    private List<String> pic;

    public NewsBean(Integer type, String title, String desc, String image, List<String> pic) {
        this.type = type;
        this.title = title;
        this.desc = desc;
        this.image = image;
        this.pic = pic;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getPic() {
        return pic;
    }

    public void setPic(List<String> pic) {
        this.pic = pic;
    }
}
