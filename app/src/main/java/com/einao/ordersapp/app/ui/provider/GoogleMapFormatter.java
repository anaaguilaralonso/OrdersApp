package com.einao.ordersapp.app.ui.provider;

import com.einao.ordersapp.domain.providers.MapFormatter;

public class GoogleMapFormatter implements MapFormatter {

    private final String API_BASE_URL = "https://maps.googleapis.com/maps/api/staticmap?";
    private final String MARKERS_ATTRIBUTE = "markers=";
    private final String ATTRIBUTE_SEPARATOR = "&";
    private final String SIZE = "size=1200x1200";
    private final String ZOOM = "zoom=12";
    private final String CENTER_ATTRIBUTE = "center=";


    @Override
    public String getMapUrl(Double lat, Double lon) {
        String url = API_BASE_URL;

        String coordinates = String.valueOf(lat) + "," + String.valueOf(lon);

        url = url + MARKERS_ATTRIBUTE + coordinates;
        url = url + ATTRIBUTE_SEPARATOR + SIZE + ATTRIBUTE_SEPARATOR + ZOOM + ATTRIBUTE_SEPARATOR;
        url = url + CENTER_ATTRIBUTE + coordinates;

        return url;
    }
}
