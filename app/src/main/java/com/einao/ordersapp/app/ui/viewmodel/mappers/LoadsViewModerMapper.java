package com.einao.ordersapp.app.ui.viewmodel.mappers;

import com.einao.ordersapp.app.ui.viewmodel.LoadViewModel;
import com.einao.ordersapp.app.ui.viewmodel.LoadsViewModel;
import com.einao.ordersapp.domain.beans.Load;
import com.einao.ordersapp.domain.beans.Loads;

import java.util.Iterator;

public class LoadsViewModerMapper {

    public LoadsViewModel map(Loads loads) {
        LoadsViewModel loadsViewModel = new LoadsViewModel();

        LoadViewModelMapper mapper = new LoadViewModelMapper();
        Iterator<Load> iterator = loads.iterator();
        while (iterator.hasNext()) {
            LoadViewModel loadViewModel = mapper.map(iterator.next());
            loadsViewModel.add(loadViewModel);
        }

        return loadsViewModel;
    }
}
