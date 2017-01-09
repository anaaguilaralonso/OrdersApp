package com.einao.ordersapp.domain;

import com.einao.ordersapp.domain.common.DomainCallback;

public interface OrdersRepository {
    void getOrders();

    void setDomainCallback(DomainCallback domainCallback);
}
