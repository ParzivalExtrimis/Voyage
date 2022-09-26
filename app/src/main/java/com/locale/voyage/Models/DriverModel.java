package com.locale.voyage.Models;

public class DriverModel extends BaseModel{
    int mExperience;
    String[] mReviews;
    boolean mOpted;

    public DriverModel(String mName, String mDesc, int mImage, int mExperience, String[] mReviews, boolean mOpted) {
        super(mName, mDesc, mImage);
        this.mExperience = mExperience;
        this.mReviews = mReviews;
        this.mOpted = mOpted;
    }

    public int getExperience() {
        return mExperience;
    }

    public String[] getReviews() {
        return mReviews;
    }

    public boolean isOpted() {
        return mOpted;
    }
}
