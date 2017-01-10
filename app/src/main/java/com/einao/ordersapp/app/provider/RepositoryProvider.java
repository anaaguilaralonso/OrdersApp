package com.einao.ordersapp.app.provider;

import com.einao.ordersapp.data.OrdersDataRepository;
import com.einao.ordersapp.domain.OrdersRepository;

public class RepositoryProvider {

    NetworkDataSourceProvider networkDataSourceProvider;
    StorageDataSourceProvider storageDataSourceProvider;

    public RepositoryProvider(NetworkDataSourceProvider networkDataSourceProvider,
                              StorageDataSourceProvider storageDataSourceProvider) {
        this.networkDataSourceProvider = networkDataSourceProvider;
        this.storageDataSourceProvider = storageDataSourceProvider;
    }

    public OrdersRepository getOrdersRepository() {
        return new OrdersDataRepository(networkDataSourceProvider.getOrdersNetworkDataSource(),
                storageDataSourceProvider.getOrdersStorageDataSource());
    }
}
