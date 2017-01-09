package com.einao.ordersapp.app.ui.viewmodel;

public class LoadViewModel {

    private String origin_date;

    private Integer weight;

    private String packageType;

    private String destination_date;

    private String name;

    private Integer status;

    private Integer price;

    private String destination_full_address;


    public String getOrigin_date() {
        return origin_date;
    }

    public void setOrigin_date(String origin_date) {
        this.origin_date = origin_date;
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

    public String getDestination_date() {
        return destination_date;
    }

    public void setDestination_date(String destination_date) {
        this.destination_date = destination_date;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDestination_full_address() {
        return destination_full_address;
    }

    public void setDestination_full_address(String destination_full_address) {
        this.destination_full_address = destination_full_address;
    }
}
