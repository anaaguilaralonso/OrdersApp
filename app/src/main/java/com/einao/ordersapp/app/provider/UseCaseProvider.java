package com.einao.ordersapp.app.provider;

import com.einao.ordersapp.domain.usecases.GetOrdersUseCase;

public class UseCaseProvider {

    RepositoryProvider repositoryProvider;

    public UseCaseProvider(RepositoryProvider repositoryProvider) {
        this.repositoryProvider = repositoryProvider;
    }

    public GetOrdersUseCase getOrdersUseCase() {
        return new GetOrdersUseCase(repositoryProvider.getOrdersRepository());
    }
}
