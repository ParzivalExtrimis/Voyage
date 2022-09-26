package com.locale.voyage.Models;

public class PackageModel extends BaseModel{
    DestinationModel[] mDestinations;
    TransportModel[] mTransportation;
    boolean mDestinationsOpted;
    boolean mDestinationsAvailable;
    boolean mTransportationAvailable;
    boolean mTransportationOpted;

    public PackageModel(String mName, String mDesc, int mImage, DestinationModel[] mDestinations, TransportModel[] mTransportation, boolean mDestinationsOpted, boolean mDestinationsAvailable, boolean mTransportationOpted, boolean mTransportationAvailable) {
        super(mName, mDesc, mImage);
        this.mDestinations = mDestinations;
        this.mTransportation = mTransportation;
        this.mDestinationsOpted = mDestinationsOpted;
        this.mDestinationsAvailable = mDestinationsAvailable;
        this.mTransportationAvailable = mTransportationAvailable;
        this.mTransportationOpted = mTransportationOpted;
    }

    public DestinationModel[] getDestinations() {
        return mDestinations;
    }

    public TransportModel[] getTransportation() {
        return mTransportation;
    }

    public boolean isDestinationsOpted() {
        return mDestinationsOpted;
    }

    public boolean isDestinationsAvailable() {
        return mDestinationsAvailable;
    }

    public boolean isTransportationAvailable() {
        return mTransportationAvailable;
    }

    public boolean isTransportationOpted() {
        return mTransportationOpted;
    }
}
