package com.einao.ordersapp.app.policy;

import com.einao.ordersapp.domain.policy.DataBasePolicy;

public class ShortDataBasePolicy implements DataBasePolicy {

    public static final int SHORT_VALID_TIME_MILLISECONDS = 10000;

    @Override
    public boolean isValid(Long lastRequest) {
        Long now = System.nanoTime() / (1000 * 1000);
        return (now - lastRequest) < SHORT_VALID_TIME_MILLISECONDS;

    }
}
