package com.einao.ordersapp.app.ui.viewmodel.mappers;

import com.einao.ordersapp.app.ui.viewmodel.LoadViewModel;
import com.einao.ordersapp.domain.beans.Load;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoadViewModelMapper {

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZ");
    SimpleDateFormat viewFormatter = new SimpleDateFormat("dd/MM/yy 'at' HH:mm:ss");

    public LoadViewModel map(Load load) {

        LoadViewModel loadViewModel = new LoadViewModel();
        loadViewModel.setWeight(load.getWeight());
        loadViewModel.setPackageType(load.getPackageType());
        loadViewModel.setName(load.getName());
        loadViewModel.setStatus(load.getStatus());
        loadViewModel.setPrice(load.getPrice() + "€");
        loadViewModel.setDestinationFullAddress(load.getDestinationFullAddress());
        try {
            Date originDate = formatter.parse(load.getOriginDate());
            Date destinationDate = formatter.parse(load.getDestinationDate());
            loadViewModel.setOriginDate(viewFormatter.format(originDate));
            loadViewModel.setDestinationDate(viewFormatter.format(destinationDate));
        } catch (ParseException e) {
            e.printStackTrace();
            loadViewModel.setOriginDate(load.getOriginDate());
            loadViewModel.setDestinationDate(load.getDestinationDate());
        }

        return loadViewModel;

    }
}
