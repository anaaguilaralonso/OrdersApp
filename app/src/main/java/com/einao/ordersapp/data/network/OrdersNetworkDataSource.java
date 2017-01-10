package com.einao.ordersapp.data.network;

import com.einao.ordersapp.data.network.common.RepositoryCallback;

public interface OrdersNetworkDataSource {
    void getOrders(RepositoryCallback repositoryCallback);

    Long getLastUpdate();
}
