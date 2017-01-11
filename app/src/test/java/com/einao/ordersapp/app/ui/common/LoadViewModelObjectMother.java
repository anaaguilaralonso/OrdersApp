package com.einao.ordersapp.app.ui.common;

import com.einao.ordersapp.app.ui.viewmodel.LoadViewModel;
import com.einao.ordersapp.app.ui.viewmodel.LoadsViewModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class LoadViewModelObjectMother {

    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy 'at' HH:mm:ss");

    public LoadsViewModel getLoadsViewModel(int count) {
        LoadsViewModel loadsViewModel = new LoadsViewModel();

        for (int i = 0; i < count; i++) {
            loadsViewModel.add(getSimpleLoadViewModel());
        }

        return loadsViewModel;
    }

    private LoadViewModel getSimpleLoadViewModel() {
        LoadViewModel load = new LoadViewModel();

        load.setDestinationFullAddress("Example string");
        load.setDestinationDate(getDate());
        load.setOriginDate(getDate());
        load.setName("Example string");
        load.setPackageType("Example string");
        load.setPrice("6€");
        load.setStatus(new Random().nextInt());
        load.setWeight(new Random().nextInt());
        load.setDestinationLat(new Random().nextDouble());
        load.setDestinationLon(new Random().nextDouble());

        return load;

    }

    public String getDate() {
        return formatter.format(new Date());
    }


}
