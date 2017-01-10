package com.einao.ordersapp.data;

import com.einao.ordersapp.data.entities.LoadsEntity;
import com.einao.ordersapp.data.entities.mappers.LoadsEntityMapper;
import com.einao.ordersapp.data.network.OrdersNetworkDataSource;
import com.einao.ordersapp.data.network.common.NetworkCallback;
import com.einao.ordersapp.data.storage.OrdersStorageDataSource;
import com.einao.ordersapp.domain.OrdersRepository;
import com.einao.ordersapp.domain.beans.Error;
import com.einao.ordersapp.domain.beans.Loads;
import com.einao.ordersapp.domain.common.DomainCallback;

public class OrdersDataRepository implements OrdersRepository {

    private final OrdersNetworkDataSource networkDataSource;
    private final OrdersStorageDataSource storageDataSource;
    private DomainCallback domainCallback;


    public OrdersDataRepository(OrdersNetworkDataSource networkDataSource, OrdersStorageDataSource storageDataSource) {
        this.networkDataSource = networkDataSource;
        this.storageDataSource = storageDataSource;
    }

    @Override
    public void getOrders(DomainCallback domainCallback) {
        this.domainCallback = domainCallback;
        networkDataSource.getOrders(networkCallback);

    }

    private final NetworkCallback networkCallback = new NetworkCallback() {
        @Override
        public void onSuccess(LoadsEntity loadsEntity) {
            LoadsEntityMapper loadsEntityMapper = new LoadsEntityMapper();
            Loads loads = loadsEntityMapper.map(loadsEntity);

            if (domainCallback == null) return;
            domainCallback.onSuccess(loads);
        }

        @Override
        public void onFailure(Error error) {
            if (domainCallback == null) return;
            domainCallback.onFailure(error);
        }
    };
}
