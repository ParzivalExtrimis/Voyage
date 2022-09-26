package com.locale.voyage.Models;

public class TransportModel {
    DriverModel mDriverChosen;
    TrainModel[] mTrains;
    boolean mDriverOpted;
    boolean mTrainOpted;
    boolean mDriverAvailable;
    boolean mTrainsAvailable;

    public TransportModel(DriverModel mDriverChosen, TrainModel[] mTrains, boolean mDriverOpted, boolean mTrainOpted, boolean mDriverAvailable, boolean mTrainsAvailable) {
        this.mDriverChosen = mDriverChosen;
        this.mTrains = mTrains;
        this.mDriverOpted = mDriverOpted;
        this.mTrainOpted = mTrainOpted;
        this.mDriverAvailable = mDriverAvailable;
        this.mTrainsAvailable = mTrainsAvailable;
    }

    public DriverModel getDriverChosen() {
        return mDriverChosen;
    }

    public TrainModel[] getTrains() {
        return mTrains;
    }

    public boolean isDriverOpted() {
        return mDriverOpted;
    }

    public boolean isTrainOpted() {
        return mTrainOpted;
    }

    public boolean isDriverAvailable() {
        return mDriverAvailable;
    }

    public boolean isTrainsAvailable() {
        return mTrainsAvailable;
    }
}
