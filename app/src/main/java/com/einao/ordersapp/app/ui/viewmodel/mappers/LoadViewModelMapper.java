package com.einao.ordersapp.app.ui.viewmodel.mappers;

import com.einao.ordersapp.app.ui.viewmodel.LoadViewModel;
import com.einao.ordersapp.domain.beans.Load;

public class LoadViewModelMapper {

    public LoadViewModel map(Load load) {

        LoadViewModel loadViewModel = new LoadViewModel();

        loadViewModel.setOriginDate(load.getOriginDate());
        loadViewModel.setWeight(load.getWeight());
        loadViewModel.setPackageType(load.getPackageType());
        loadViewModel.setDestinationDate(load.getDestinationDate());
        loadViewModel.setName(load.getName());
        loadViewModel.setStatus(load.getStatus());
        loadViewModel.setPrice(load.getPrice()+"€");
        loadViewModel.setDestinationFullAddress(load.getDestinationFullAddress());

        return loadViewModel;

    }
}
