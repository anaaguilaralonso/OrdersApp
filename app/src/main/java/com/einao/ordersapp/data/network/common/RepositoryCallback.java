package com.einao.ordersapp.data.network.common;

import com.einao.ordersapp.data.entities.LoadsEntity;
import com.einao.ordersapp.domain.beans.Error;

public interface RepositoryCallback {

    void onSuccess(LoadsEntity loadsEntity);

    void onFailure(Error error);
}
