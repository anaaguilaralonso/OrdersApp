package com.einao.ordersapp.app.ui.provider;

import com.einao.ordersapp.domain.providers.MapFormatter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class GoogleMapFormatter implements MapFormatter {

    private String googleApiUrl = "https://maps.googleapis.com/maps/api/staticmap?";
    private Map<String, String> properties;

    public GoogleMapFormatter() {
        properties = new HashMap<>();

        setCommonProperties();
    }

    private void setCommonProperties() {
        properties.put("zoom", "10");
        properties.put("size", "1200x1200");
    }

    @Override
    public String getMapUrl(Double lat, Double lon) {
        properties.put("center", lat + "," + lon);
        properties.put("markers", lat + "," + lon);

        String url = googleApiUrl;

        Set<String> mapProperties = properties.keySet();
        Iterator<String> iterator = mapProperties.iterator();
        while (iterator.hasNext()) {
            String property = iterator.next();
            url = url + property + "=" + properties.get(property) + "&";
        }
        url = url.substring(0, url.length() - 1);

        return url;
    }
}
