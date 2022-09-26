package com.locale.voyage.Models;

public class HotelModel extends BaseModel{
    float mRating;
    int mAvailability;
    String[] mReviews;
    String[] mFeatures;
    boolean mOpted;
    int mPrice;
    int[] mOtherImages;

    public HotelModel(String name, String desc, int main_img, int[] other_images, float rating, int availability, String[] reviews, String[] features, int price) {
        super(name, desc, main_img);
        this.mOtherImages = other_images;
        this.mRating = rating;
        this.mAvailability = availability;
        this.mReviews = reviews;
        this.mFeatures = features;
        this.mPrice = price;
    }


    public float getRating() {
        return mRating;
    }

    public int getAvailability() {
        return mAvailability;
    }

    public String[] getFeatures() { return mFeatures; }

    public String[] getReviews() {
        return mReviews;
    }

    public boolean isOpted() {
        return mOpted;
    }

    public int getPrice() { return mPrice; }

    public int[] getOtherImages() { return mOtherImages; }
}
