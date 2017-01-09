package com.einao.ordersapp.domain.beans;

public class Load {

    private String shiper;

    private String origin_date;

    private Integer weight;

    private String packageType;

    private String destination_date_end;

    private Integer size_width;

    private Integer distance;

    private String destination_date;

    private String destination_companyName;

    private String name;

    private Integer size_height;

    private String driver;

    private Integer quantity;

    private Integer status;

    private Double origin_lon;

    private String origin;

    private Double destination_lat;

    private String origin_full_address;

    private Double origin_lat;

    private String destination;

    private Integer price;

    private String origin_companyName;

    private String freightType;

    private Integer size_length;

    private String origin_contactName;

    private String destination_full_address;

    private Double destination_lon;

    private String destination_contactName;

    private String extra_info;

    private String origin_date_end;

    private Load(Builder builder) {
        shiper = builder.shiper;
        origin_date = builder.origin_date;
        weight = builder.weight;
        packageType = builder.packageType;
        destination_date_end = builder.destination_date_end;
        size_width = builder.size_width;
        distance = builder.distance;
        destination_date = builder.destination_date;
        destination_companyName = builder.destination_companyName;
        name = builder.name;
        size_height = builder.size_height;
        driver = builder.driver;
        quantity = builder.quantity;
        status = builder.status;
        origin_lon = builder.origin_lon;
        origin = builder.origin;
        destination_lat = builder.destination_lat;
        origin_full_address = builder.origin_full_address;
        origin_lat = builder.origin_lat;
        destination = builder.destination;
        price = builder.price;
        origin_companyName = builder.origin_companyName;
        freightType = builder.freightType;
        size_length = builder.size_length;
        origin_contactName = builder.origin_contactName;
        destination_full_address = builder.destination_full_address;
        destination_lon = builder.destination_lon;
        destination_contactName = builder.destination_contactName;
        extra_info = builder.extra_info;
        origin_date_end = builder.origin_date_end;
    }


    public static final class Builder {
        private String shiper;
        private String origin_date;
        private Integer weight;
        private String packageType;
        private String destination_date_end;
        private Integer size_width;
        private Integer distance;
        private String destination_date;
        private String destination_companyName;
        private String name;
        private Integer size_height;
        private String driver;
        private Integer quantity;
        private Integer status;
        private Double origin_lon;
        private String origin;
        private Double destination_lat;
        private String origin_full_address;
        private Double origin_lat;
        private String destination;
        private Integer price;
        private String origin_companyName;
        private String freightType;
        private Integer size_length;
        private String origin_contactName;
        private String destination_full_address;
        private Double destination_lon;
        private String destination_contactName;
        private String extra_info;
        private String origin_date_end;

        public Builder() {
        }

        public Builder shiper(String val) {
            shiper = val;
            return this;
        }

        public Builder origin_date(String val) {
            origin_date = val;
            return this;
        }

        public Builder weight(Integer val) {
            weight = val;
            return this;
        }

        public Builder packageType(String val) {
            packageType = val;
            return this;
        }

        public Builder destination_date_end(String val) {
            destination_date_end = val;
            return this;
        }

        public Builder size_width(Integer val) {
            size_width = val;
            return this;
        }

        public Builder distance(Integer val) {
            distance = val;
            return this;
        }

        public Builder destination_date(String val) {
            destination_date = val;
            return this;
        }

        public Builder destination_companyName(String val) {
            destination_companyName = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder size_height(Integer val) {
            size_height = val;
            return this;
        }

        public Builder driver(String val) {
            driver = val;
            return this;
        }

        public Builder quantity(Integer val) {
            quantity = val;
            return this;
        }

        public Builder status(Integer val) {
            status = val;
            return this;
        }

        public Builder origin_lon(Double val) {
            origin_lon = val;
            return this;
        }

        public Builder origin(String val) {
            origin = val;
            return this;
        }

        public Builder destination_lat(Double val) {
            destination_lat = val;
            return this;
        }

        public Builder origin_full_address(String val) {
            origin_full_address = val;
            return this;
        }

        public Builder origin_lat(Double val) {
            origin_lat = val;
            return this;
        }

        public Builder destination(String val) {
            destination = val;
            return this;
        }

        public Builder price(Integer val) {
            price = val;
            return this;
        }

        public Builder origin_companyName(String val) {
            origin_companyName = val;
            return this;
        }

        public Builder freightType(String val) {
            freightType = val;
            return this;
        }

        public Builder size_length(Integer val) {
            size_length = val;
            return this;
        }

        public Builder origin_contactName(String val) {
            origin_contactName = val;
            return this;
        }

        public Builder destination_full_address(String val) {
            destination_full_address = val;
            return this;
        }

        public Builder destination_lon(Double val) {
            destination_lon = val;
            return this;
        }

        public Builder destination_contactName(String val) {
            destination_contactName = val;
            return this;
        }

        public Builder extra_info(String val) {
            extra_info = val;
            return this;
        }

        public Builder origin_date_end(String val) {
            origin_date_end = val;
            return this;
        }

        public Load build() {
            return new Load(this);
        }
    }

    public String getShiper() {
        return shiper;
    }

    public String getOrigin_date() {
        return origin_date;
    }

    public Integer getWeight() {
        return weight;
    }

    public String getPackageType() {
        return packageType;
    }

    public String getDestination_date_end() {
        return destination_date_end;
    }

    public Integer getSize_width() {
        return size_width;
    }

    public Integer getDistance() {
        return distance;
    }

    public String getDestination_date() {
        return destination_date;
    }

    public String getDestination_companyName() {
        return destination_companyName;
    }

    public String getName() {
        return name;
    }

    public Integer getSize_height() {
        return size_height;
    }

    public String getDriver() {
        return driver;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getStatus() {
        return status;
    }

    public Double getOrigin_lon() {
        return origin_lon;
    }

    public String getOrigin() {
        return origin;
    }

    public Double getDestination_lat() {
        return destination_lat;
    }

    public String getOrigin_full_address() {
        return origin_full_address;
    }

    public Double getOrigin_lat() {
        return origin_lat;
    }

    public String getDestination() {
        return destination;
    }

    public Integer getPrice() {
        return price;
    }

    public String getOrigin_companyName() {
        return origin_companyName;
    }

    public String getFreightType() {
        return freightType;
    }

    public Integer getSize_length() {
        return size_length;
    }

    public String getOrigin_contactName() {
        return origin_contactName;
    }

    public String getDestination_full_address() {
        return destination_full_address;
    }

    public Double getDestination_lon() {
        return destination_lon;
    }

    public String getDestination_contactName() {
        return destination_contactName;
    }

    public String getExtra_info() {
        return extra_info;
    }

    public String getOrigin_date_end() {
        return origin_date_end;
    }
}
