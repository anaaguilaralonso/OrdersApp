package com.einao.ordersapp.domain.policy;

public interface DataBasePolicy {

    boolean isValid(Long lastRequest);
}
