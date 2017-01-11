package com.einao.ordersapp.app.provider;

import com.einao.ordersapp.data.storage.OrdersStorageDataSource;
import com.einao.ordersapp.data.storage.OrdersStorageDataSourceFirebase;

public class StorageDataSourceProvider {

    public OrdersStorageDataSource getOrdersStorageDataSource() {
        return new OrdersStorageDataSourceFirebase();
    }
}
