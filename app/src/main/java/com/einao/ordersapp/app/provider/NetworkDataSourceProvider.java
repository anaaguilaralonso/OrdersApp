package com.einao.ordersapp.app.provider;

import com.einao.ordersapp.data.network.OrdersNetworkDataSource;
import com.einao.ordersapp.data.network.firebase.OrdersNetworkDataSourceFirebase;
import com.einao.ordersapp.domain.providers.TimeProvider;

public class NetworkDataSourceProvider {

    public OrdersNetworkDataSource getOrdersNetworkDataSource(TimeProvider timeProvider) {
        return new OrdersNetworkDataSourceFirebase(timeProvider);
    }
}
