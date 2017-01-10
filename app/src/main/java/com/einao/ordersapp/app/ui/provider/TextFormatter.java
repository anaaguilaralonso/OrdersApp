package com.einao.ordersapp.app.ui.provider;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TextFormatter {

    public String getDateDisplay(String stringDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZ");
        SimpleDateFormat viewFormatter = new SimpleDateFormat("dd/MM/yy 'at' HH:mm");

        String formattedDate;
        try {
            Date date = formatter.parse(stringDate);
            formattedDate = viewFormatter.format(date);
        } catch (ParseException e) {
            formattedDate = stringDate;
        }

        return formattedDate;
    }

    public String getCurrencyDisplay(Integer price) {
        return String.valueOf(price).concat("€");
    }
}
