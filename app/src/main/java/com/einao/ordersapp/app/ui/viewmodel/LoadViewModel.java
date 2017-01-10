package com.einao.ordersapp.app.ui.viewmodel;

public class LoadViewModel {

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
}
