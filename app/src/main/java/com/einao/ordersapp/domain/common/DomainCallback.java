package com.einao.ordersapp.domain.common;

import com.einao.ordersapp.domain.beans.Error;

public interface DomainCallback<TDomain> {
    void onFailure(Error error);

    void onSuccess(TDomain result);
}
