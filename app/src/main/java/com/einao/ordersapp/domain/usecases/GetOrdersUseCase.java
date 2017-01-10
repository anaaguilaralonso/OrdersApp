package com.einao.ordersapp.domain.usecases;

import com.einao.ordersapp.domain.OrdersRepository;
import com.einao.ordersapp.domain.UseCaseCallback;
import com.einao.ordersapp.domain.beans.Error;
import com.einao.ordersapp.domain.beans.Loads;
import com.einao.ordersapp.domain.common.DomainCallback;

public class GetOrdersUseCase extends UseCase<Loads> {

    private final OrdersRepository ordersDataRepository;
    private UseCaseCallback<Loads> useCaseCallback;

    public GetOrdersUseCase(OrdersRepository ordersDataRepository) {
        this.ordersDataRepository = ordersDataRepository;
    }

    @Override
    public void execute(UseCaseCallback<Loads> useCaseCallback) {
        this.useCaseCallback = useCaseCallback;
        ordersDataRepository.getOrders(domainCallback);
    }

    protected final DomainCallback<Loads> domainCallback = new DomainCallback<Loads>() {
        @Override
        public void onFailure(Error error) {
            useCaseCallback.onFailure(error);
        }

        @Override
        public void onSuccess(Loads loads) {
            useCaseCallback.onSuccess(loads);
        }
    };
}
