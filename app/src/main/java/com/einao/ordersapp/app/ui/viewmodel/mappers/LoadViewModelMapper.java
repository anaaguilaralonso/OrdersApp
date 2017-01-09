package com.einao.ordersapp.app.ui.viewmodel.mappers;

import com.einao.ordersapp.app.ui.viewmodel.LoadViewModel;
import com.einao.ordersapp.domain.beans.Load;

public class LoadViewModelMapper {

    public LoadViewModel map(Load load) {

        LoadViewModel loadViewModel = new LoadViewModel();

        loadViewModel.setOrigin_date(load.getOrigin_date());
        loadViewModel.setWeight(load.getWeight());
        loadViewModel.setPackageType(load.getPackageType());
        loadViewModel.setDestination_date(load.getDestination_date());
        loadViewModel.setName(load.getName());
        loadViewModel.setStatus(load.getStatus());
        loadViewModel.setPrice(load.getPrice()+"€");
        loadViewModel.setDestination_full_address(load.getDestination_full_address());

        return loadViewModel;

    }
}
