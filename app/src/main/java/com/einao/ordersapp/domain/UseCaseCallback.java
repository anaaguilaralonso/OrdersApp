package com.einao.ordersapp.domain;

import com.einao.ordersapp.domain.beans.Error;

public interface UseCaseCallback<T> {
    void onError(Error error);

    void onSuccess(T data);
}
