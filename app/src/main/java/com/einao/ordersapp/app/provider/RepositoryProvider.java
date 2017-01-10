package com.einao.ordersapp.app.provider;

import com.einao.ordersapp.data.OrdersDataRepository;
import com.einao.ordersapp.domain.OrdersRepository;
import com.einao.ordersapp.domain.policy.DataBasePolicy;

public class RepositoryProvider {

    private final NetworkDataSourceProvider networkDataSourceProvider;
    private final StorageDataSourceProvider storageDataSourceProvider;
    private final DataBasePolicy dataBasePolicy;

    public RepositoryProvider(NetworkDataSourceProvider networkDataSourceProvider,
                              StorageDataSourceProvider storageDataSourceProvider,
                              DataBasePolicy dataBasePolicy) {
        this.networkDataSourceProvider = networkDataSourceProvider;
        this.storageDataSourceProvider = storageDataSourceProvider;
        this.dataBasePolicy = dataBasePolicy;
    }


    public OrdersRepository getOrdersRepository() {
        return new OrdersDataRepository(networkDataSourceProvider.getOrdersNetworkDataSource(),
                storageDataSourceProvider.getOrdersStorageDataSource(), dataBasePolicy);
    }
}
