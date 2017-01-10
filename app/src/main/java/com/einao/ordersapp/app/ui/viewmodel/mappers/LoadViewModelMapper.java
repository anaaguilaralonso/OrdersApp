package com.einao.ordersapp.app.ui.viewmodel.mappers;

import com.einao.ordersapp.app.ui.provider.TextFormatter;
import com.einao.ordersapp.app.ui.viewmodel.LoadViewModel;
import com.einao.ordersapp.domain.beans.Load;


public class LoadViewModelMapper {

    private final TextFormatter textFormatter;

    public LoadViewModelMapper(TextFormatter textFormatter) {
        this.textFormatter = textFormatter;
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

        return loadViewModel;

    }
}
