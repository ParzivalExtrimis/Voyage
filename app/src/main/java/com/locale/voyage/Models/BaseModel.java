package com.locale.voyage.Models;

public class BaseModel {
    String mName;
    String mDesc;
    int mImage;

    public BaseModel(String mName, String mDesc, int mImage) {
        this.mName = mName;
        this.mDesc = mDesc;
        this.mImage = mImage;
    }

    //getters

    public String getName() {
        return mName;
    }

    public String getDesc() {
        return mDesc;
    }

    public int getImage() {
        return mImage;
    }

}
