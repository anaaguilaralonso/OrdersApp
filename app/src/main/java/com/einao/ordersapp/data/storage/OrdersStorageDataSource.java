package com.einao.ordersapp.data.storage;

import com.einao.ordersapp.data.network.common.RepositoryCallback;

public interface OrdersStorageDataSource {
    void getOrders(RepositoryCallback repositoryCallback);
}
