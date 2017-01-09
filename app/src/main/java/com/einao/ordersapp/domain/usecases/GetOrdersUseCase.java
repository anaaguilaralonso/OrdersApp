package com.einao.ordersapp.domain.usecases;

import com.einao.ordersapp.data.OrdersDataRepository;
import com.einao.ordersapp.domain.UseCaseCallback;
import com.einao.ordersapp.domain.beans.Error;
import com.einao.ordersapp.domain.beans.Loads;
import com.einao.ordersapp.domain.common.DomainCallback;

public class GetOrdersUseCase extends UseCase<Loads, Void> {

    private final OrdersDataRepository ordersDataRepository;
    private UseCaseCallback<Loads> useCaseCallback;

    public GetOrdersUseCase(OrdersDataRepository ordersDataRepository) {
        this.ordersDataRepository = ordersDataRepository;
    }

    @Override
    public void execute() {
        ordersDataRepository.setDomainCallback(domainCallback);
        ordersDataRepository.getOrders();
    }

    @Override
    public void addCallback(UseCaseCallback<Loads> useCaseCallback) {
        this.useCaseCallback = useCaseCallback;
    }

    @Override
    public void stopCallback() {
        this.useCaseCallback = null;
    }


    private final DomainCallback domainCallback = new DomainCallback() {
        @Override
        public void onFailure(Error error) {
            useCaseCallback.onError(error);
        }

        @Override
        public void onSuccess(Loads loads) {
            useCaseCallback.onSuccess(loads);
        }
    };
}
