package com.einao.ordersapp.domain.usecases;

import com.einao.ordersapp.domain.UseCaseCallback;

public abstract class UseCase<TResponse, Param> {

    public abstract void execute(UseCaseCallback<TResponse> ordersUserCase);

}
