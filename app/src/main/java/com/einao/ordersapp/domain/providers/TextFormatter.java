package com.einao.ordersapp.domain.providers;

public interface TextFormatter {

    String getDateDisplay(String stringDate);

    String getCurrencyDisplay(Integer price);
}
