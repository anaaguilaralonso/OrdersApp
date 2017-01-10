package com.einao.ordersapp.domain.beans;

public class Load {

    private String shiper;

    private String originDate;

    private Integer weight;

    private String packageType;

    private String destinationDateEnd;

    private Integer size_width;

    private Integer distance;

    private String destinationDate;

    private String destinationCompanyName;

    private String name;

    private Integer sizeHeight;

    private String driver;

    private Integer quantity;

    private Integer status;

    private Double originLon;

    private String origin;

    private Double destinationLat;

    private String originFullAddress;

    private Double origin_lat;

    private String destination;

    private Integer price;

    private String originCompanyName;

    private String freightType;

    private Integer sizeLength;

    private String originContactName;

    private String destinationFullAddress;

    private Double destinationLon;

    private String destinationContactName;

    private String extraInfo;

    private String originDateEnd;

    private Load(Builder builder) {
        shiper = builder.shiper;
        originDate = builder.originDate;
        weight = builder.weight;
        packageType = builder.packageType;
        destinationDateEnd = builder.destinationDateEnd;
        size_width = builder.sizeWidth;
        distance = builder.distance;
        destinationDate = builder.destinationDate;
        destinationCompanyName = builder.destinationCompanyName;
        name = builder.name;
        sizeHeight = builder.sizeHeight;
        driver = builder.driver;
        quantity = builder.quantity;
        status = builder.status;
        originLon = builder.originLon;
        origin = builder.origin;
        destinationLat = builder.destinationLat;
        originFullAddress = builder.originFullAddress;
        origin_lat = builder.originLat;
        destination = builder.destination;
        price = builder.price;
        originCompanyName = builder.originCompanyName;
        freightType = builder.freightType;
        sizeLength = builder.sizeLength;
        originContactName = builder.originContactName;
        destinationFullAddress = builder.destinationFullAddress;
        destinationLon = builder.destinationLon;
        destinationContactName = builder.destinationContactName;
        extraInfo = builder.extraInfo;
        originDateEnd = builder.originDateEnd;
    }


    public static final class Builder {
        private String shiper;
        private String originDate;
        private Integer weight;
        private String packageType;
        private String destinationDateEnd;
        private Integer sizeWidth;
        private Integer distance;
        private String destinationDate;
        private String destinationCompanyName;
        private String name;
        private Integer sizeHeight;
        private String driver;
        private Integer quantity;
        private Integer status;
        private Double originLon;
        private String origin;
        private Double destinationLat;
        private String originFullAddress;
        private Double originLat;
        private String destination;
        private Integer price;
        private String originCompanyName;
        private String freightType;
        private Integer sizeLength;
        private String originContactName;
        private String destinationFullAddress;
        private Double destinationLon;
        private String destinationContactName;
        private String extraInfo;
        private String originDateEnd;

        public Builder() {
        }

        public Builder shiper(String val) {
            shiper = val;
            return this;
        }

        public Builder origin_date(String val) {
            originDate = val;
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
            destinationDateEnd = val;
            return this;
        }

        public Builder size_width(Integer val) {
            sizeWidth = val;
            return this;
        }

        public Builder distance(Integer val) {
            distance = val;
            return this;
        }

        public Builder destination_date(String val) {
            destinationDate = val;
            return this;
        }

        public Builder destination_companyName(String val) {
            destinationCompanyName = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder size_height(Integer val) {
            sizeHeight = val;
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
            originLon = val;
            return this;
        }

        public Builder origin(String val) {
            origin = val;
            return this;
        }

        public Builder destination_lat(Double val) {
            destinationLat = val;
            return this;
        }

        public Builder origin_full_address(String val) {
            originFullAddress = val;
            return this;
        }

        public Builder origin_lat(Double val) {
            originLat = val;
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
            originCompanyName = val;
            return this;
        }

        public Builder freightType(String val) {
            freightType = val;
            return this;
        }

        public Builder size_length(Integer val) {
            sizeLength = val;
            return this;
        }

        public Builder origin_contactName(String val) {
            originContactName = val;
            return this;
        }

        public Builder destination_full_address(String val) {
            destinationFullAddress = val;
            return this;
        }

        public Builder destination_lon(Double val) {
            destinationLon = val;
            return this;
        }

        public Builder destination_contactName(String val) {
            destinationContactName = val;
            return this;
        }

        public Builder extra_info(String val) {
            extraInfo = val;
            return this;
        }

        public Builder origin_date_end(String val) {
            originDateEnd = val;
            return this;
        }

        public Load build() {
            return new Load(this);
        }
    }

    public String getShiper() {
        return shiper;
    }

    public String getOriginDate() {
        return originDate;
    }

    public Integer getWeight() {
        return weight;
    }

    public String getPackageType() {
        return packageType;
    }

    public String getDestinationDateEnd() {
        return destinationDateEnd;
    }

    public Integer getSize_width() {
        return size_width;
    }

    public Integer getDistance() {
        return distance;
    }

    public String getDestinationDate() {
        return destinationDate;
    }

    public String getDestinationCompanyName() {
        return destinationCompanyName;
    }

    public String getName() {
        return name;
    }

    public Integer getSizeHeight() {
        return sizeHeight;
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

    public Double getOriginLon() {
        return originLon;
    }

    public String getOrigin() {
        return origin;
    }

    public Double getDestinationLat() {
        return destinationLat;
    }

    public String getOriginFullAddress() {
        return originFullAddress;
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

    public String getOriginCompanyName() {
        return originCompanyName;
    }

    public String getFreightType() {
        return freightType;
    }

    public Integer getSizeLength() {
        return sizeLength;
    }

    public String getOriginContactName() {
        return originContactName;
    }

    public String getDestinationFullAddress() {
        return destinationFullAddress;
    }

    public Double getDestinationLon() {
        return destinationLon;
    }

    public String getDestinationContactName() {
        return destinationContactName;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public String getOriginDateEnd() {
        return originDateEnd;
    }
}
