package com.einao.ordersapp.app.policy;

import com.einao.ordersapp.domain.policy.DataBasePolicy;
import com.einao.ordersapp.domain.providers.TimeProvider;

public class ShortDataBasePolicy implements DataBasePolicy {

    private final int SHORT_VALID_TIME_MILLISECONDS = 10000;

    private final TimeProvider timeProvider;

    public ShortDataBasePolicy(TimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }

    @Override
    public boolean isValid(Long lastRequest) {
        Long now = timeProvider.getCurrentTimeInMiliseconds();
        return (now - lastRequest) < SHORT_VALID_TIME_MILLISECONDS;

    }
}
