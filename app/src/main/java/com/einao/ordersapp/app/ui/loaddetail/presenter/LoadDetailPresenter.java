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
        view.get().setViewInformation(loadViewModel);
    }

    public void setLoad(LoadViewModel loadViewModel) {
        this.loadViewModel = loadViewModel;
    }
}
