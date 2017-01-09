package com.einao.ordersapp.data.network;

import com.einao.ordersapp.data.network.common.NetworkCallback;

public interface OrdersNetworkDataSource {
    void getOrders();
    void setCallback(NetworkCallback networkCallback);
}
