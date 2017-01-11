package com.einao.ordersapp.app.ui.viewmodel.mappers;

import com.einao.ordersapp.app.ui.viewmodel.LoadViewModel;
import com.einao.ordersapp.app.ui.viewmodel.LoadsViewModel;
import com.einao.ordersapp.domain.beans.Load;
import com.einao.ordersapp.domain.beans.Loads;
import com.einao.ordersapp.domain.providers.MapFormatter;
import com.einao.ordersapp.domain.providers.TextFormatter;

import java.util.Iterator;

public class LoadsViewModelMapper {

    private final TextFormatter textFormatter;
    private final MapFormatter mapFormatter;

    public LoadsViewModelMapper(TextFormatter textFormatter, MapFormatter mapFormatter) {
        this.textFormatter = textFormatter;
        this.mapFormatter = mapFormatter;
    }

    public LoadsViewModel map(Loads loads) {
        LoadsViewModel loadsViewModel = new LoadsViewModel();

        LoadViewModelMapper mapper = new LoadViewModelMapper(textFormatter, mapFormatter);
        Iterator<Load> iterator = loads.iterator();
        while (iterator.hasNext()) {
            LoadViewModel loadViewModel = mapper.map(iterator.next());
            loadsViewModel.add(loadViewModel);
        }

        return loadsViewModel;
    }
}
