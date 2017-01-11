package com.einao.ordersapp.app.ui.provider;

import com.einao.ordersapp.domain.providers.TimeProvider;

public class AndroidTimeProvider implements TimeProvider {

    @Override
    public Long getCurrentTimeInMiliseconds() {
        return System.nanoTime() / (1000 * 10000);
    }
}
