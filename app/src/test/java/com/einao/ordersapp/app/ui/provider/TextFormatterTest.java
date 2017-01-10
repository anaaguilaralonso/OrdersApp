package com.einao.ordersapp.app.ui.provider;

import com.einao.ordersapp.domain.providers.TextFormatter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TextFormatterTest {

    TextFormatter textFormatter;

    @Before
    public void init() {
        textFormatter = new OrdersTextFormatter();
    }

    @Test
    public void onValidDate_formatDate() {
        String validDate = "2016-04-29T08:00+0200";

        String dateDisplay = textFormatter.getDateDisplay(validDate);

        Assert.assertTrue(dateDisplay.compareTo("29/04/16 at 08:00") == 0);
    }

    @Test
    public void onInValidDate_formatDate() {
        String invalidDate = "2016/04-29T08:00";

        String dateDisplay = textFormatter.getDateDisplay(invalidDate);

        Assert.assertTrue(dateDisplay.compareTo(invalidDate) == 0);
    }

    @Test
    public void onPrice_setCurrency() {
        int price = 10;

        String priceFormatted = textFormatter.getCurrencyDisplay(price);

        Assert.assertTrue(priceFormatted.compareTo(price + "€") == 0);
    }

}