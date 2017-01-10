package com.einao.ordersapp.app.ui.loaddetail.presenter;

import com.einao.ordersapp.app.ui.common.Presenter;
import com.einao.ordersapp.app.ui.loaddetail.view.LoadDetailView;
import com.einao.ordersapp.app.ui.viewmodel.LoadViewModel;

public class LoadDetailPresenter extends Presenter<LoadDetailView> {

    LoadViewModel loadViewModel;

    public LoadDetailPresenter(LoadDetailView loadDetailView) {
        super(loadDetailView);
    }

    @Override
    public void start() {
        if (loadViewModel == null) return;
        showLoadInformation(loadViewModel);
    }

    private void showLoadInformation(LoadViewModel loadViewModel) {
        if (!existView()) return;
        view.get().setDestination(loadViewModel.getDestinationFullAddress());
        view.get().setName(loadViewModel.getName());
        view.get().setPackageType(loadViewModel.getPackageType());
        view.get().setOriginDate(loadViewModel.getOriginDate());
        view.get().setDestinationDate(loadViewModel.getDestinationDate());
        view.get().setPrice(loadViewModel.getPrice());
        view.get().setStatus(loadViewModel.getStatus());
        view.get().setWeight(loadViewModel.getWeight());
    }

    public void setLoad(LoadViewModel loadViewModel) {
        this.loadViewModel = loadViewModel;
    }
}
