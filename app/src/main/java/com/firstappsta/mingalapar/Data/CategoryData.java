package com.firstappsta.mingalapar.Data;

import com.firstappsta.mingalapar.Utility.Constant;

import java.io.Serializable;

public class CategoryData implements Serializable{

    private Constant.Category category;
    private int imgId;
    private String title;
    private String info;

    public CategoryData(Constant.Category category, int imgId, String title, String info) {
        this.category = category;
        this.imgId = imgId;
        this.title = title;
        this.info = info;
    }

    public Constant.Category getCategory() {
        return category;
    }

    public void setCategory(Constant.Category category) {
        this.category = category;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}


