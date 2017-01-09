package com.einao.ordersapp.domain.common;

import com.einao.ordersapp.domain.beans.Error;
import com.einao.ordersapp.domain.beans.Loads;

public interface DomainCallback {
    void onFailure(Error error);

    void onSuccess(Loads loads);
}
