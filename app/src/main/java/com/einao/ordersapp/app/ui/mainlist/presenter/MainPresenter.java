package com.einao.ordersapp.app.ui.mainlist.presenter;

import com.einao.ordersapp.app.ui.common.Presenter;
import com.einao.ordersapp.domain.usecases.OrdersUseCase;

public class MainPresenter extends Presenter {


    private OrdersUseCase ordersUserCase;

    public MainPresenter(OrdersUseCase ordersUserCase) {
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
