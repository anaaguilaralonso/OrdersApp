package com.einao.ordersapp.domain.common;

import com.einao.ordersapp.domain.beans.Load;
import com.einao.ordersapp.domain.beans.Loads;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class LoadsObjectMother {

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZ");

    public Loads getLoads(int loadCount) {
        Loads loads = new Loads();

        for (int i = 0; i < loadCount; i++) {
            loads.add(getSimpleLoad());
        }

        return loads;
    }

    public Load getSimpleLoad() {
        Load.Builder builder = new Load.Builder();

        builder.destination("Example string");
        builder.destination_contactName("Example string");
        builder.destination_companyName("Example string");
        builder.destination_date(getDate());
        builder.destination_date_end(getDate());
        builder.destination_full_address("Example string");
        builder.destination_lat(new Random().nextDouble());
        builder.destination_lon(new Random().nextDouble());
        builder.distance(new Random().nextInt());
        builder.driver("Example string");
        builder.extra_info("Example string");
        builder.freightType("Example string");
        builder.name("Example string");
        builder.origin("Example string");
        builder.origin_companyName("Example string");
        builder.origin_contactName("Example string");
        builder.origin_date(getDate());
        builder.origin_date_end(getDate());
        builder.origin_full_address("Example string");
        builder.origin_lat(new Random().nextDouble());
        builder.origin_lon(new Random().nextDouble());
        builder.packageType("Example string");
        builder.price(new Random().nextInt());
        builder.quantity(new Random().nextInt());
        builder.shiper("Example string");
        builder.size_height(new Random().nextInt());
        builder.size_length(new Random().nextInt());
        builder.size_width(new Random().nextInt());
        builder.status(new Random().nextInt());
        builder.weight(new Random().nextInt());

        return builder.build();
    }

    public String getDate() {
        return formatter.format(new Date());
    }
}
