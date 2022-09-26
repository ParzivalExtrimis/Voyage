package com.locale.voyage.Models;

public class DestinationModel extends BaseModel{

    HotelModel mHotels[];
    boolean mHotelOpted;

    public DestinationModel(String mName, String mDesc, int mImage, HotelModel[] mHotels, boolean mHotelOpted) {
        super(mName, mDesc, mImage);
        this.mHotels = mHotels;
        this.mHotelOpted = mHotelOpted;
    }

    //getters

    public boolean isHotelOpted() {
        return mHotelOpted;
    }
    public HotelModel[] getHotels() {
        return mHotels;
    }

}
