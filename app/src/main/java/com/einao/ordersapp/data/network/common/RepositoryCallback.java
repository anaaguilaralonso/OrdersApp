package com.einao.ordersapp.data.network.common;

import com.einao.ordersapp.domain.beans.Error;

public interface RepositoryCallback<TEntity> {

    void onSuccess(TEntity result);

    void onFailure(Error error);
}
