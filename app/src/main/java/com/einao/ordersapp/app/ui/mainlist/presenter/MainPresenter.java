package com.einao.ordersapp.app.ui.mainlist.presenter;

import com.einao.ordersapp.app.ui.common.Presenter;
import com.einao.ordersapp.domain.usecases.GetOrdersUseCase;

public class MainPresenter extends Presenter {


    private GetOrdersUseCase ordersUserCase;

    public MainPresenter(GetOrdersUseCase ordersUserCase) {
        this.ordersUserCase = ordersUserCase;
    }

    @Override
    public void start() {
        getOrders();
    }

    public void getOrders() {
        ordersUserCase.execute();
    }
}
