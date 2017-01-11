package com.einao.ordersapp.app.ui.viewmodel.mappers;

import com.einao.ordersapp.app.ui.viewmodel.LoadViewModel;
import com.einao.ordersapp.domain.beans.Load;
import com.einao.ordersapp.domain.providers.MapFormatter;
import com.einao.ordersapp.domain.providers.TextFormatter;


public class LoadViewModelMapper {

    private final TextFormatter textFormatter;
    private final MapFormatter mapFormatter;

    public LoadViewModelMapper(TextFormatter textFormatter, MapFormatter mapFormater) {
        this.textFormatter = textFormatter;
        this.mapFormatter = mapFormater;
    }

    public LoadViewModel map(Load load) {

        LoadViewModel loadViewModel = new LoadViewModel();
        loadViewModel.setWeight(load.getWeight());
        loadViewModel.setPackageType(load.getPackageType());
        loadViewModel.setName(load.getName());
        loadViewModel.setStatus(load.getStatus());
        loadViewModel.setPrice(textFormatter.getCurrencyDisplay(load.getPrice()));
        loadViewModel.setDestinationFullAddress(load.getDestinationFullAddress());
        loadViewModel.setOriginDate(textFormatter.getDateDisplay(load.getOriginDate()));
        loadViewModel.setDestinationDate(textFormatter.getDateDisplay(load.getDestinationDate()));
        loadViewModel.setMapUrl(mapFormatter.getMapUrl(load.getDestinationLat(), load.getDestinationLon()));

        return loadViewModel;

    }
}
