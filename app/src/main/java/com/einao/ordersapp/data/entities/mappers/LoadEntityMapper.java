package com.einao.ordersapp.data.entities.mappers;

import com.einao.ordersapp.data.entities.LoadEntity;
import com.einao.ordersapp.domain.beans.Load;

public class LoadEntityMapper {

    public Load map(LoadEntity loadEntity) {

        Load.Builder builder = new Load.Builder();

        builder.destination(loadEntity.getDestination());
        builder.destination_contactName(loadEntity.getDestination_contactName());
        builder.destination_companyName(loadEntity.getDestination_companyName());
        builder.destination_date(loadEntity.getDestination_date());
        builder.destination_date_end(loadEntity.getDestination_date_end());
        builder.destination_full_address(loadEntity.getDestination_full_address());
        builder.destination_lat(loadEntity.getDestination_lat());
        builder.destination_lon(loadEntity.getDestination_lon());
        builder.distance(loadEntity.getDistance());
        builder.driver(loadEntity.getDriver());
        builder.extra_info(loadEntity.getExtra_info());
        builder.freightType(loadEntity.getFreightType());
        builder.name(loadEntity.getName());
        builder.origin(loadEntity.getOrigin());
        builder.origin_companyName(loadEntity.getOrigin_companyName());
        builder.origin_contactName(loadEntity.getOrigin_contactName());
        builder.origin_date(loadEntity.getOrigin_date());
        builder.origin_date_end(loadEntity.getOrigin_date_end());
        builder.origin_full_address(loadEntity.getOrigin_full_address());
        builder.origin_lat(loadEntity.getOrigin_lat());
        builder.origin_lon(loadEntity.getOrigin_lon());
        builder.packageType(loadEntity.getPackageType());
        builder.price(loadEntity.getPrice());
        builder.quantity(loadEntity.getQuantity());
        builder.shiper(loadEntity.getShiper());
        builder.size_height(loadEntity.getSize_height());
        builder.size_length(loadEntity.getSize_length());
        builder.size_width(loadEntity.getSize_width());
        builder.status(loadEntity.getStatus());
        builder.weight(loadEntity.getWeight());

        return builder.build();
    }

}
