package com.einao.ordersapp.app.provider;

import com.einao.ordersapp.data.network.OrdersNetworkDataSource;
import com.einao.ordersapp.data.network.firebase.OrdersNetworkDataSourceFirebase;

public class NetworkDataSourceProvider {

    public OrdersNetworkDataSource getOrdersNetworkDataSource() {
        return new OrdersNetworkDataSourceFirebase();
    }
}
