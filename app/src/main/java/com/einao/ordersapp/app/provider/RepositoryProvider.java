package com.einao.ordersapp.app.provider;

import com.einao.ordersapp.data.OrdersDataRepository;
import com.einao.ordersapp.domain.OrdersRepository;
import com.einao.ordersapp.domain.policy.DataBasePolicy;
import com.einao.ordersapp.domain.providers.TimeProvider;

public class RepositoryProvider {

    private final NetworkDataSourceProvider networkDataSourceProvider;
    private final StorageDataSourceProvider storageDataSourceProvider;
    private final DataBasePolicy dataBasePolicy;
    private final TimeProvider timeProvider;

    public RepositoryProvider(NetworkDataSourceProvider networkDataSourceProvider,
                              StorageDataSourceProvider storageDataSourceProvider,
                              DataBasePolicy dataBasePolicy, TimeProvider timeProvider) {
        this.networkDataSourceProvider = networkDataSourceProvider;
        this.storageDataSourceProvider = storageDataSourceProvider;
        this.dataBasePolicy = dataBasePolicy;
        this.timeProvider = timeProvider;
    }


    public OrdersRepository getOrdersRepository() {
        return new OrdersDataRepository(networkDataSourceProvider.getOrdersNetworkDataSource(timeProvider),
                storageDataSourceProvider.getOrdersStorageDataSource(), dataBasePolicy);
    }
}
