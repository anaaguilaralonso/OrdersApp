package com.einao.ordersapp.data.network.common;

import com.einao.ordersapp.domain.beans.Error;
import com.einao.ordersapp.data.entities.LoadsEntity;

public interface RepositoryCallback {

    void onSuccess(LoadsEntity loadsEntity);

    void onFailure(Error error);
}
