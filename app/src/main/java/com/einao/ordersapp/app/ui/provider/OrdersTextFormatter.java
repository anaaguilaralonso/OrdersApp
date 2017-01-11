package com.einao.ordersapp.app.ui.provider;

import com.einao.ordersapp.domain.providers.TextFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class OrdersTextFormatter implements TextFormatter {

    @Override
    public String getDateDisplay(String stringDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZ", Locale.getDefault());
        SimpleDateFormat viewFormatter = new SimpleDateFormat("dd/MM/yy 'at' HH:mm", Locale.getDefault());

        String formattedDate;
        try {
            Date date = formatter.parse(stringDate);
            formattedDate = viewFormatter.format(date);
        } catch (ParseException e) {
            formattedDate = stringDate;
        }

        return formattedDate;
    }

    @Override
    public String getCurrencyDisplay(Integer price) {
        return String.valueOf(price).concat("€");
    }
}
