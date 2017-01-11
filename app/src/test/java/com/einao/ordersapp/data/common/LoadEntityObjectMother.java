package com.einao.ordersapp.data.common;

import com.einao.ordersapp.data.entities.LoadEntity;
import com.einao.ordersapp.data.entities.LoadsEntity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class LoadEntityObjectMother {

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZ");

    public LoadsEntity getLoads(int loadCount) {
        LoadsEntity loads = new LoadsEntity();

        for (int i = 0; i < loadCount; i++) {
            loads.add(getSimpleLoad());
        }

        return loads;
    }

    public LoadEntity getSimpleLoad() {
        LoadEntity loadEntity = new LoadEntity();

        loadEntity.setDestination("Example string");
        loadEntity.setDestination_contactName("Example string");
        loadEntity.setDestination_companyName("Example string");
        loadEntity.setDestination_date(getDate());
        loadEntity.setDestination_date_end(getDate());
        loadEntity.setDestination_full_address("Example string");
        loadEntity.setDestination_lat(new Random().nextDouble());
        loadEntity.setDestination_lon(new Random().nextDouble());
        loadEntity.setDistance(new Random().nextInt());
        loadEntity.setDriver("Example string");
        loadEntity.setExtra_info("Example string");
        loadEntity.setFreightType("Example string");
        loadEntity.setName("Example string");
        loadEntity.setOrigin("Example string");
        loadEntity.setOrigin_companyName("Example string");
        loadEntity.setOrigin_contactName("Example string");
        loadEntity.setOrigin_date(getDate());
        loadEntity.setOrigin_date_end(getDate());
        loadEntity.setOrigin_full_address("Example string");
        loadEntity.setOrigin_lat(new Random().nextDouble());
        loadEntity.setOrigin_lon(new Random().nextDouble());
        loadEntity.setPackageType("Example string");
        loadEntity.setPrice(new Random().nextInt());
        loadEntity.setQuantity(new Random().nextInt());
        loadEntity.setShiper("Example string");
        loadEntity.setSize_height(new Random().nextInt());
        loadEntity.setSize_length(new Random().nextInt());
        loadEntity.setSize_width(new Random().nextInt());
        loadEntity.setStatus(new Random().nextInt());
        loadEntity.setWeight(new Random().nextInt());

        return loadEntity;
    }

    public String getDate() {
        return formatter.format(new Date());
    }
}
