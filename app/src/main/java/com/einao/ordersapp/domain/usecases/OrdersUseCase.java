package com.einao.ordersapp.domain.usecases;

import com.einao.ordersapp.data.OrdersDataRepository;

public class OrdersUseCase extends UseCase {

    OrdersDataRepository ordersDataRepository;

    public OrdersUseCase(OrdersDataRepository ordersDataRepository) {
        this.ordersDataRepository = ordersDataRepository;
    }

    @Override
    public void execute() {
        ordersDataRepository.getOrders();
    }
}
