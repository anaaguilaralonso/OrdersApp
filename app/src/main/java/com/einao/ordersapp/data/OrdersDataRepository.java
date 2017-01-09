package com.einao.ordersapp.data;

import com.einao.ordersapp.data.network.OrdersNetworkDataSource;
import com.einao.ordersapp.data.storage.OrdersStorageDataSource;
import com.einao.ordersapp.domain.OrdersRepository;

public class OrdersDataRepository implements OrdersRepository {

    private final OrdersNetworkDataSource networkDataSource;
    private final OrdersStorageDataSource storageDataSource;


    public OrdersDataRepository(OrdersNetworkDataSource networkDataSource, OrdersStorageDataSource storageDataSource) {
        this.networkDataSource = networkDataSource;
        this.storageDataSource = storageDataSource;
    }

    @Override
    public void getOrders() {
        networkDataSource.getOrders();
    }
}
