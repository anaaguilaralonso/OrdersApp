package com.einao.ordersapp.app.ui.viewmodel;

import android.os.Parcel;
import android.os.Parcelable;

public class LoadViewModel implements Parcelable {

    private String originDate;

    private Integer weight;

    private String packageType;

    private String destinationDate;

    private String name;

    private Integer status;

    private String price;

    private String destinationFullAddress;


    public String getOriginDate() {
        return originDate;
    }

    public void setOriginDate(String originDate) {
        this.originDate = originDate;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public String getDestinationDate() {
        return destinationDate;
    }

    public void setDestinationDate(String destinationDate) {
        this.destinationDate = destinationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDestinationFullAddress() {
        return destinationFullAddress;
    }

    public void setDestinationFullAddress(String destinationFullAddress) {
        this.destinationFullAddress = destinationFullAddress;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.originDate);
        dest.writeValue(this.weight);
        dest.writeString(this.packageType);
        dest.writeString(this.destinationDate);
        dest.writeString(this.name);
        dest.writeValue(this.status);
        dest.writeString(this.price);
        dest.writeString(this.destinationFullAddress);
    }

    public LoadViewModel() {
    }

    protected LoadViewModel(Parcel in) {
        this.originDate = in.readString();
        this.weight = (Integer) in.readValue(Integer.class.getClassLoader());
        this.packageType = in.readString();
        this.destinationDate = in.readString();
        this.name = in.readString();
        this.status = (Integer) in.readValue(Integer.class.getClassLoader());
        this.price = in.readString();
        this.destinationFullAddress = in.readString();
    }

    public static final Parcelable.Creator<LoadViewModel> CREATOR = new Parcelable.Creator<LoadViewModel>() {
        @Override
        public LoadViewModel createFromParcel(Parcel source) {
            return new LoadViewModel(source);
        }

        @Override
        public LoadViewModel[] newArray(int size) {
            return new LoadViewModel[size];
        }
    };
}
