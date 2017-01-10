package com.einao.ordersapp.domain;

import com.einao.ordersapp.domain.beans.Error;

public interface UseCaseCallback<T> {
    void onFailure(Error error);

    void onSuccess(T data);
}
