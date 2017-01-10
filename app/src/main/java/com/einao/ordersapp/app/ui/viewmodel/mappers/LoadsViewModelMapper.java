package com.einao.ordersapp.app.ui.viewmodel.mappers;

import com.einao.ordersapp.app.ui.viewmodel.LoadViewModel;
import com.einao.ordersapp.app.ui.viewmodel.LoadsViewModel;
import com.einao.ordersapp.domain.beans.Load;
import com.einao.ordersapp.domain.beans.Loads;
import com.einao.ordersapp.domain.providers.TextFormatter;

import java.util.Iterator;

public class LoadsViewModelMapper {

    private final TextFormatter textFormatter;

    public LoadsViewModelMapper(TextFormatter textFormatter) {
        this.textFormatter = textFormatter;
    }

    public LoadsViewModel map(Loads loads) {
        LoadsViewModel loadsViewModel = new LoadsViewModel();

        LoadViewModelMapper mapper = new LoadViewModelMapper(textFormatter);
        Iterator<Load> iterator = loads.iterator();
        while (iterator.hasNext()) {
            LoadViewModel loadViewModel = mapper.map(iterator.next());
            loadsViewModel.add(loadViewModel);
        }

        return loadsViewModel;
    }
}
